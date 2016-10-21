package it.lorenzorapetti.pokemaster.utils.recyclerview

import android.support.v7.widget.RecyclerView
import android.view.View

abstract class MvpViewHolder<M>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    abstract fun bind(item: M)

}