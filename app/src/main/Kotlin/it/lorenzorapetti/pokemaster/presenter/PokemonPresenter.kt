package it.lorenzorapetti.pokemaster.presenter

import it.lorenzorapetti.pokemaster.models.view.PokemonModelView
import it.lorenzorapetti.pokemaster.utils.getAll
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.util.*

class PokemonPresenter {

    var items: MutableList<PokemonModelView> = ArrayList()

    fun loadData(callback: ((data: MutableList<PokemonModelView>?) -> Unit)? = null) {
        doAsync {
            items = getAll(PokemonModelView::class)

            uiThread {
                if (callback != null) callback(items)
            }
        }
    }

}