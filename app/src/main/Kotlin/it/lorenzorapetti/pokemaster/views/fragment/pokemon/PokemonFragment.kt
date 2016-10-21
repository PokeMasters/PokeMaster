package it.lorenzorapetti.pokemaster.views.fragment.pokemon

import android.support.v4.app.Fragment
import it.lorenzorapetti.pokemaster.R
import it.lorenzorapetti.pokemaster.views.fragment.base.BaseBottomBarFragment
import java.util.*

class PokemonFragment : BaseBottomBarFragment(defaultTabPosition = 1) {

    companion object {
        const val TAG = "PokemonFragment"
    }

    override val mFragments: HashMap<Int, Fragment> = hashMapOf(
            R.id.tab_captured to PokemonCapturedFragment(),
            R.id.tab_general to PokemonGeneralFragment(),
            R.id.tab_favorites to PokemonFavoritesFragment())

}