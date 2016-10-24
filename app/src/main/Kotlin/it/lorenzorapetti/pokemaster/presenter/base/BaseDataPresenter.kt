package it.lorenzorapetti.pokemaster.presenter.base

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter
import it.lorenzorapetti.pokemaster.views.base.DataView
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

/**
 * An abstract implementation of [MvpBasePresenter] that takes care of handling the data loading.
 * It implements a [load] function that will be called by the View.
 * The only thing that the presenter that will extends this class must do is to override [loadData]
 * and take care of loading the data or displaying a message.
 *
 * @author Lorenzo Rapetti
 */
abstract class BaseDataPresenter<M> : MvpBasePresenter<DataView<M>>() {

    /**
     * Shows the loading screen while it calls [loadData]. Than, if the result from [loadData]
     * is not null, it displays the content
     */
    fun load() {
        //view?.showLoading(false)

        doAsync {
            val items = loadData()

            items?.let {
                uiThread {
                    view?.let {
                        it.setData(items)
                        it.showContent()
                    }
                }
            }
        }
    }

    /**
     * Loads the data
     *
     * @return The data loaded or null
     */
    protected abstract fun loadData(): M?

}