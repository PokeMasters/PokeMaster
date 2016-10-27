package it.lorenzorapetti.pokemaster.adapter

import android.support.v7.widget.RecyclerView
import android.view.View

abstract class MvpViewHolder<in M>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    abstract fun bind(item: M, position: Int)

}