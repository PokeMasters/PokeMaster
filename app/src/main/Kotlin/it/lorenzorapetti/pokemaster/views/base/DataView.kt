package it.lorenzorapetti.pokemaster.views.base

import com.hannesdorfmann.mosby.mvp.lce.MvpLceView

/**
 * A [MvpLceView] that adds a method for showing empty data
 */
interface DataView<M> : MvpLceView<M> {

    /**
     * Show a message for empty data
     */
    fun showMessage(message: String)

}