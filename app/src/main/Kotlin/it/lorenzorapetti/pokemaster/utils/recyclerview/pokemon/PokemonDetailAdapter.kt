package it.lorenzorapetti.pokemaster.utils.recyclerview.pokemon

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import it.lorenzorapetti.pokemaster.R
import it.lorenzorapetti.pokemaster.models.view.PokemonModelView
import it.lorenzorapetti.pokemaster.utils.getSugimoriThumbUrl
import it.lorenzorapetti.pokemaster.utils.recyclerview.MvpRecyclerAdapter
import it.lorenzorapetti.pokemaster.utils.recyclerview.MvpViewHolder
import it.lorenzorapetti.pokemaster.utils.viewById

class PokemonDetailAdapter : MvpRecyclerAdapter<PokemonModelView>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MvpViewHolder<PokemonModelView> {
        val view = LayoutInflater.from(parent!!.context)
                .inflate(R.layout.item_pokemon_detail, parent, false)
        return PokemonDetailViewHolder(view)
    }

    class PokemonDetailViewHolder : MvpViewHolder<PokemonModelView> {

        val avatar: ImageView
        val name: TextView
        val number: TextView
        val primaryType: ImageView
        val secondaryType: ImageView

        constructor(itemView: View) : super(itemView) {
            avatar = viewById(R.id.list_image) as ImageView
            name = viewById(R.id.list_title) as TextView
            number = viewById(R.id.list_subtitle) as TextView
            primaryType = viewById(R.id.list_primary_icon) as ImageView
            secondaryType = viewById(R.id.list_secondary_icon) as ImageView
        }

        override fun bind(item: PokemonModelView) {
            Picasso.with(itemView.context)
                    .load(item.formName.getSugimoriThumbUrl())
                    .into(avatar)

            name.text = item.name
            number.text = "#${item.id}"
        }

    }
}