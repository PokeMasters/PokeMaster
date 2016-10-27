package it.lorenzorapetti.pokemaster.views.fragment.pokemon

import android.support.v7.widget.RecyclerView

class PokemonFavoritesFragment : PokemonGeneralFragment() {

    override fun createAdapterDataObserver() = object: RecyclerView.AdapterDataObserver() {
        override fun onChanged() {
            adapter.mItems.clear()
            adapter.mItems.addAll(presenter.items.filter { it.isFavorite })
        }
    }

}