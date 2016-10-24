package it.lorenzorapetti.pokemaster.adapter.decoration

import android.graphics.drawable.Drawable

interface ViewHolderSwipeAdapter {

    fun getLeftDrawable(): Drawable

    fun getRightDrawable(): Drawable

    fun onSwiped(swipedPosition: Int)

}