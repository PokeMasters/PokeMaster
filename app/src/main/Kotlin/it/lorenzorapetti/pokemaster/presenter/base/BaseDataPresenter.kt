package it.lorenzorapetti.pokemaster.presenter.base

import android.util.Log
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter
import it.lorenzorapetti.pokemaster.views.base.DataView
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

abstract class BaseDataPresenter<M> : MvpBasePresenter<DataView<M>>() {

    fun load() {
        view?.showLoading(false)

        doAsync {
            val items = loadData()
            Log.d("App", "load: ${items}")

            items.let {
                uiThread {
                    view?.let {
                        Log.d("App", "uiThread")
                        it.setData(items)
                        it.showContent()
                    }
                }
            }
        }
    }

    protected abstract fun loadData(): M?

}