package it.lorenzorapetti.pokemaster.views.fragment.pokemon

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import it.lorenzorapetti.pokemaster.R
import it.lorenzorapetti.pokemaster.adapter.pokemon.PokemonPresenterAdapter
import it.lorenzorapetti.pokemaster.models.view.PokemonModelView
import it.lorenzorapetti.pokemaster.presenter.PokemonPresenter
import it.lorenzorapetti.pokemaster.views.fragment.base.BaseBottomBarFragment
import kotlinx.android.synthetic.main.fragment_mvplce_base.*
import kotlin.properties.Delegates

open class PokemonGeneralFragment(
        val layoutRes: Int = R.layout.fragment_mvplce_base
) : Fragment(), BaseBottomBarFragment.Callbacks<PokemonModelView> {

    var adapter by Delegates.notNull<PokemonPresenterAdapter>()

    var presenter by Delegates.notNull<PokemonPresenter>()

    //region Lifecycle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(layoutRes, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = createAdapter()
        adapter.registerAdapterDataObserver(createAdapterDataObserver())
        contentView.layoutManager = LinearLayoutManager(activity)
        contentView.adapter = adapter
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        if (!hidden) adapter.notifyDataSetChanged()
    }

    //endregion

    //region Override BottomBarItemFragment

    override fun onDataLoaded(items: MutableList<PokemonModelView>) {
        adapter.notifyDataSetChanged()
        showContent()
    }

    override fun showEmptyMessage() {
        showMessage(resources.getString(R.string.error_no_pokemon))
    }

    //endregion

    //region Methods

    open fun createAdapter() =
            PokemonPresenterAdapter(activity, presenter)

    open fun createAdapterDataObserver() = object: RecyclerView.AdapterDataObserver() {
        override fun onChanged() {
            adapter.mItems.clear()
            adapter.mItems.addAll(presenter.items)
        }
    }

    fun showMessage() {
        loadingView.visibility = View.GONE
        contentView.visibility = View.GONE
        errorView.visibility = View.VISIBLE
    }

    fun showLoading() {
        loadingView.visibility = View.VISIBLE
        contentView.visibility = View.GONE
        errorView.visibility = View.GONE
    }

    fun showContent() {
        loadingView.visibility = View.GONE
        contentView.visibility = View.VISIBLE
        errorView.visibility = View.GONE
    }

    fun showMessage(message: String) {
        errorView.text = message
        showMessage()
    }

    //endregion

}