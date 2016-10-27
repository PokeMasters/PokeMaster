package it.lorenzorapetti.pokemaster.adapter

import com.daimajia.swipe.adapters.RecyclerSwipeAdapter
import it.lorenzorapetti.pokemaster.R
import java.util.*

abstract class MvpRecyclerAdapter<M> : RecyclerSwipeAdapter<MvpViewHolder<M>> {

    var items: MutableList<M> = ArrayList()

    constructor(items: ArrayList<M>? = null) {
        items?.let { this.items = it }
    }

    override fun onBindViewHolder(holder: MvpViewHolder<M>?, position: Int) {
        holder?.bind(items[position], position)
    }

    override fun getItemCount() = items.size

    //region Override RecyclerSwipeAdapter

    override fun getSwipeLayoutResourceId(position: Int) = R.id.swipe

    //endregion

    //region Public methods

    fun setData(items: MutableList<M>) {
        this.items.clear()
        addAll(items)
    }

    fun addAll(items: MutableList<M>) {
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

}