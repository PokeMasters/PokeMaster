package it.lorenzorapetti.pokemaster.views.fragment.pokemon

import android.os.Bundle
import android.view.View
import it.lorenzorapetti.pokemaster.R
import it.lorenzorapetti.pokemaster.presenter.PokemonPresenter
import it.lorenzorapetti.pokemaster.views.fragment.base.BaseBottomBarFragment
import kotlinx.android.synthetic.main.fragment_bottom_bar.*
import kotlin.properties.Delegates

class PokemonFragment :
        BaseBottomBarFragment<PokemonGeneralFragment>(defaultTabPosition = 1) {

    companion object {
        const val TAG = "PokemonFragment"
    }

    override val mFragments = hashMapOf(
            R.id.tab_captured to PokemonCapturedFragment(),
            R.id.tab_general to PokemonGeneralFragment(),
            R.id.tab_favorites to PokemonFavoritesFragment())

    private var mPresenter by Delegates.notNull<PokemonPresenter>()

    //region Lifecycle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter = PokemonPresenter()
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mFragments.forEach { it.value.presenter = mPresenter }
        mPresenter.loadData {
            mFragments[bottomBar.currentTabId]?.adapter?.notifyDataSetChanged()
        }
    }

    //endregion

}