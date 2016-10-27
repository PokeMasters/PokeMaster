package it.lorenzorapetti.pokemaster.adapter.pokemon

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.daimajia.swipe.adapters.RecyclerSwipeAdapter
import com.squareup.picasso.Picasso
import it.lorenzorapetti.pokemaster.R
import it.lorenzorapetti.pokemaster.adapter.MvpViewHolder
import it.lorenzorapetti.pokemaster.models.view.PokemonModelView
import it.lorenzorapetti.pokemaster.presenter.PokemonPresenter
import it.lorenzorapetti.pokemaster.utils.findPokemonString
import it.lorenzorapetti.pokemaster.utils.findTypeDrawableResource
import it.lorenzorapetti.pokemaster.utils.getSugimoriThumbUrl
import it.lorenzorapetti.pokemaster.utils.viewById
import java.util.*

class PokemonPresenterAdapter(
        var context: Context,
        presenter: PokemonPresenter,
        var layoutRes: Int = R.layout.item_pokemon_detail
) : RecyclerSwipeAdapter<MvpViewHolder<PokemonModelView>>() {

    var mItems: MutableList<PokemonModelView> = ArrayList()

    init {
        mItems.clear()
        mItems.addAll(presenter.items)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MvpViewHolder<PokemonModelView> {
        val v = LayoutInflater.from(context).inflate(layoutRes, parent, false)
        return PokemonDetailViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: MvpViewHolder<PokemonModelView>?, position: Int) {
        viewHolder?.bind(mItems[position], position)
    }

    override fun getItemCount() = mItems.size

    //region Override RecyclerSwipeAdapter

    override fun getSwipeLayoutResourceId(position: Int) = R.id.swipe

    //endregion

    class PokemonDetailViewHolder : MvpViewHolder<PokemonModelView> {

        val avatar: ImageView
        val name: TextView
        val number: TextView
        val primaryType: ImageView
        val secondaryType: ImageView
        val actionFavorites: ImageView
        val actionCaptured: ImageView

        constructor(itemView: View) : super(itemView) {
            avatar = viewById(R.id.list_image) as ImageView
            name = viewById(R.id.list_title) as TextView
            number = viewById(R.id.list_subtitle) as TextView
            primaryType = viewById(R.id.list_primary_icon) as ImageView
            secondaryType = viewById(R.id.list_secondary_icon) as ImageView
            actionFavorites = viewById(R.id.list_action_favorites) as ImageView
            actionCaptured = viewById(R.id.list_action_captured) as ImageView
        }

        override fun bind(item: PokemonModelView, position: Int) {
            Picasso.with(itemView.context)
                    .load(item.formName.getSugimoriThumbUrl())
                    .into(avatar)

            val pokemonName = itemView.context.findPokemonString(item.formName)
            name.text = pokemonName
            number.text = "#${item.pokemonSpeciesId.toString().padStart(3, '0')}"

            val primaryTypeDrawable = itemView.context.findTypeDrawableResource(item.primaryTypeName)
            if (primaryTypeDrawable != 0) {
                Picasso.with(itemView.context)
                        .load(primaryTypeDrawable)
                        .into(primaryType)
            }

            var secondaryTypeDrawable = 0
            item.secondaryTypeName?.let {
                secondaryTypeDrawable = itemView.context.findTypeDrawableResource(it)
            }
            if (secondaryTypeDrawable != 0) {
                secondaryType.visibility = View.VISIBLE
                Picasso.with(itemView.context)
                        .load(secondaryTypeDrawable)
                        .into(secondaryType)
            } else {
                secondaryType.visibility = View.GONE
            }

            if (item.isFavorite) {
                actionFavorites.contentDescription =
                        itemView.context.getString(R.string.action_remove_from_favorites)
            } else {
                actionFavorites.contentDescription =
                        itemView.context.getString(R.string.action_add_to_favorites)
            }
            actionFavorites.setOnClickListener {
                item.toggleFavorite {
                    val message: String
                    if (it) {
                        message = itemView.context.getString(
                                R.string.message_pokemon_added_to_favorites, pokemonName)
                    } else {
                        message = itemView.context.getString(
                                R.string.message_pokemon_removed_from_favorites, pokemonName)
                    }
                    Toast.makeText(itemView.context, message, Toast.LENGTH_SHORT).show()
                    Log.d("App", "Favorite: ${item.isFavorite}")
                }
            }

            if (item.isCaptured) {
                actionCaptured.contentDescription =
                        itemView.context.getString(R.string.action_remove_from_captured)
            } else {
                actionCaptured.contentDescription =
                        itemView.context.getString(R.string.action_add_to_captured)
            }
            actionCaptured.setOnClickListener {
                item.toggleCaptured {
                    val message: String
                    if (it) {
                        message = itemView.context.getString(
                                R.string.message_pokemon_added_to_captured, pokemonName)
                    } else {
                        message = itemView.context.getString(
                                R.string.message_pokemon_removed_from_captured, pokemonName)
                    }
                    Toast.makeText(itemView.context, message, Toast.LENGTH_SHORT).show()
                    Log.d("App", "Captured: ${item.isCaptured}")
                }
            }
        }
    }

}