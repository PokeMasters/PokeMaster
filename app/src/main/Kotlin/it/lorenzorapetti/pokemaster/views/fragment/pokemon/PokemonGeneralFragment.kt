package it.lorenzorapetti.pokemaster.views.fragment.pokemon

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.view.View
import it.lorenzorapetti.pokemaster.models.view.PokemonModelView
import it.lorenzorapetti.pokemaster.presenter.PokemonGeneralPresenter
import it.lorenzorapetti.pokemaster.adapter.pokemon.PokemonDetailAdapter
import it.lorenzorapetti.pokemaster.views.fragment.base.BaseMvpListFragment

class PokemonGeneralFragment :
        BaseMvpListFragment<PokemonModelView, PokemonGeneralPresenter, PokemonDetailAdapter>() {

    override fun createAdapter() = PokemonDetailAdapter(activity)

    override fun createPresenter() = PokemonGeneralPresenter()

    override fun onBeforeLoadData(view: View?, savedInstanceState: Bundle?) {
        contentView.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
    }
}