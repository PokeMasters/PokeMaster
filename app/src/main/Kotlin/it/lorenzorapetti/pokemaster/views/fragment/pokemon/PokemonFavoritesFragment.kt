package it.lorenzorapetti.pokemaster.views.fragment.pokemon

import android.support.v7.widget.RecyclerView
import it.lorenzorapetti.pokemaster.R
import it.lorenzorapetti.pokemaster.adapter.pokemon.PokemonPresenterAdapter

class PokemonFavoritesFragment : PokemonGeneralFragment() {

    override fun createAdapterDataObserver() = object: RecyclerView.AdapterDataObserver() {
        override fun onChanged() {
            adapter.mItems.clear()
            adapter.mItems.addAll(presenter.items.filter { it.isFavorite })
        }
    }

    override fun createAdapter() =
            PokemonPresenterAdapter(activity, presenter, R.layout.list_item_pokemon_with_close)

}