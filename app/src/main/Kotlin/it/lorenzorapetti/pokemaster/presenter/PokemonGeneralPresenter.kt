package it.lorenzorapetti.pokemaster.presenter

import it.lorenzorapetti.pokemaster.models.view.PokemonModelView
import it.lorenzorapetti.pokemaster.presenter.base.BaseDataPresenter
import it.lorenzorapetti.pokemaster.utils.getAllAsArrayList
import java.util.*

/**
 * An implementation of [BaseDataPresenter] that loads the pokémon.
 *
 * @author Lorenzo Rapetti
 */
class PokemonGeneralPresenter : BaseDataPresenter<ArrayList<PokemonModelView>>() {

    override fun loadData() = getAllAsArrayList(PokemonModelView::class)
}