package it.lorenzorapetti.pokemaster.views.fragment.base

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hannesdorfmann.mosby.mvp.lce.MvpLceFragment
import it.lorenzorapetti.pokemaster.R
import it.lorenzorapetti.pokemaster.presenter.base.BaseDataPresenter
import it.lorenzorapetti.pokemaster.adapter.MvpRecyclerAdapter
import it.lorenzorapetti.pokemaster.views.base.DataView
import java.util.*
import kotlin.properties.Delegates

abstract class BaseMvpListFragment<M, P: BaseDataPresenter<ArrayList<M>>> :
        MvpLceFragment<RecyclerView, ArrayList<M>, DataView<ArrayList<M>>, P>(), DataView<ArrayList<M>> {

    protected open val mLayoutRes: Int = R.layout.fragment_mvplce_base

    protected abstract val mAdapter: MvpRecyclerAdapter<M>

    //region Fragment lifecycle

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(mLayoutRes, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        contentView.layoutManager = LinearLayoutManager(activity)
        contentView.adapter = mAdapter
        onBeforeLoadData(view, savedInstanceState)
        Log.d("App", "beforeLoad")
        this.loadData(false)
    }

    //endregion

    //region Override MvpLceView methods

    override fun setData(data: ArrayList<M>?) {
        Log.d("App", "Items: ${data?.size}")
        data?.let {
            mAdapter.setData(it)
        }
    }

    override fun loadData(pullToRefresh: Boolean) {
        Log.d("App", "loadData")
        presenter.load()
    }

    //endregion

    //region Override DataView methods

    override fun showMessage(message: String) {
        Log.d("App", "showMessage: $message")
        contentView.visibility = View.GONE
        loadingView.visibility = View.GONE
        errorView.visibility = View.VISIBLE
        errorView.text = message
    }

    //endregion

    //region Override MvpLceFragment methods

    override fun getErrorMessage(e: Throwable?, pullToRefresh: Boolean): String? {
        Log.d("App", "getErrorMessage: ${e?.message}")
        return e?.message
    }

    //endregion

    //region Public methods

    abstract fun onBeforeLoadData(view: View?, savedInstanceState: Bundle?)

    //endregion
}