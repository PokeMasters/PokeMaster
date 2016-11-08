package it.lorenzorapetti.pokemaster.adapter.pokemon

import android.content.Context
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
import it.lorenzorapetti.pokemaster.utils.*
import java.util.*

class PokemonPresenterAdapter(
        var context: Context,
        presenter: PokemonPresenter,
        var layoutRes: Int = R.layout.list_item_pokemon,
        val favorite: Boolean = true
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

    inner class PokemonDetailViewHolder : MvpViewHolder<PokemonModelView> {

        val avatar: ImageView
        val name: TextView
        val number: TextView
        val primaryType: ImageView
        val secondaryType: ImageView
        val actionFavorites: ImageView?
        val actionCaptured: ImageView?
        val actionDelete: ImageView?

        constructor(itemView: View) : super(itemView) {
            avatar = viewById(R.id.list_image) as ImageView
            name = viewById(R.id.list_title) as TextView
            number = viewById(R.id.list_subtitle) as TextView
            primaryType = viewById(R.id.list_primary_icon) as ImageView
            secondaryType = viewById(R.id.list_secondary_icon) as ImageView
            actionFavorites = viewById(R.id.list_action_favorites) as? ImageView
            actionCaptured = viewById(R.id.list_action_captured) as? ImageView
            actionDelete = viewById(R.id.list_action_delete) as? ImageView
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

            actionFavorites?.let {

                if (item.isFavorite) {
                    actionFavorites.setImageResource(R.drawable.ic_bookmarks_white_full)
                } else {
                    actionFavorites.setImageResource(R.drawable.ic_bookmarks_white)
                }
                actionFavorites.setOnClickListener {
                    item.toggleFavorite {
                        val messageRes = if (it) R.string.message_pokemon_added_to_favorites
                                        else R.string.message_pokemon_removed_from_favorites
                        val message = itemView.context.getString(messageRes, pokemonName)
                        toast(itemView.context, message)

                        //Close side menu and notify the adapter that the item has been changed
                        this@PokemonPresenterAdapter.closeItem(position)
                        this@PokemonPresenterAdapter.notifyItemChanged(position)
                    }
                }

            }

            actionCaptured?.let {

                if (item.isCaptured) {
                    actionCaptured.setImageResource(R.drawable.ic_captured_white_full)
                } else {
                    actionCaptured.setImageResource(R.drawable.ic_captured_white)
                }
                actionCaptured.setOnClickListener {
                    item.toggleCaptured {
                        val messageRes = if (it) R.string.message_pokemon_added_to_captured
                                        else R.string.message_pokemon_removed_from_captured
                        val message = itemView.context.getString(messageRes, pokemonName)
                        toast(itemView.context, message)

                        //Close side menu and notify the adapter that the item has been changed
                        this@PokemonPresenterAdapter.closeItem(position)
                        this@PokemonPresenterAdapter.notifyItemChanged(position)
                    }
                }

            }

            actionDelete?.setOnClickListener {
                if (favorite) {
                    item.deleteFromFavorites {
                        toast(itemView.context,
                                itemView.context.getString(
                                        R.string.message_pokemon_removed_from_favorites, pokemonName))
                        //Close side menu and notify the adapter that the item has been changed
                        this@PokemonPresenterAdapter.closeItem(position)
                        this@PokemonPresenterAdapter.notifyDataSetChanged()
                    }
                } else {
                    item.deleteFromCaptured {
                        toast(itemView.context,
                                itemView.context.getString(
                                        R.string.message_pokemon_removed_from_captured, pokemonName))
                        //Close side menu and notify the adapter that the item has been changed
                        this@PokemonPresenterAdapter.closeItem(position)
                        this@PokemonPresenterAdapter.notifyDataSetChanged()
                    }
                }
            }
        }
    }

}