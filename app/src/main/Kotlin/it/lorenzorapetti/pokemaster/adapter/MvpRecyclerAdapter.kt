package it.lorenzorapetti.pokemaster.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import java.util.*

abstract class MvpRecyclerAdapter<M> : RecyclerView.Adapter<MvpRecyclerAdapter.MvpViewHolder<M>> {

    var items: ArrayList<M> = ArrayList()

    constructor(items: ArrayList<M>? = null) {
        items?.let { this.items = it }
    }

    override fun onBindViewHolder(holder: MvpViewHolder<M>?, position: Int) {
        holder?.bind(items[position])
    }

    override fun getItemCount() = items.size

    //region Public methods

    fun setData(items: ArrayList<M>) {
        this.items.clear()
        addAll(items)
    }

    fun addAll(items: ArrayList<M>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun addItem(item: M) {
        items.add(item)
        notifyDataSetChanged()
    }

    fun removeItem(item: M) {
        val index = items.indexOf(item)
        items.remove(item)
        notifyItemRemoved(index)
    }

    fun removeItem(position: Int) {
        items.removeAt(position)
        notifyItemRemoved(position)
    }

    //endregion

    abstract class MvpViewHolder<M>(itemView: View) : RecyclerView.ViewHolder(itemView) {

        abstract fun bind(item: M)

    }
}