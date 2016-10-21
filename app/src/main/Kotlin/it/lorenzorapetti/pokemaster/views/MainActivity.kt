package it.lorenzorapetti.pokemaster.views

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import it.lorenzorapetti.pokemaster.R
import it.lorenzorapetti.pokemaster.utils.findOrCreateFragment
import it.lorenzorapetti.pokemaster.views.fragment.pokemon.PokemonFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.partial_toolbar.*

/**
 * The main activity containing the navigation view to navigate
 * through (almost) all the screens
 *
 * @author Lorenzo Rapetti
 */
class MainActivity : AppCompatActivity() {

    var mDrawerToggle: ActionBarDrawerToggle? = null

    companion object {
        const val NAVIGATION_DRAWER_DELAY = 500L
    }

    //region Activity lifecycle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        navigation_view.setNavigationItemSelectedListener { selectItem(it) }

        mDrawerToggle = ActionBarDrawerToggle(this, drawer_layout, toolbar, R.string.app_name,
                R.string.app_name)
        drawer_layout.addDrawerListener(mDrawerToggle!!)
        mDrawerToggle!!.syncState()

        if (savedInstanceState == null) {
            navigation_view.setCheckedItem(R.id.menu_main_pokemon)
            navigate(R.id.menu_main_pokemon)
        }
    }

    //endregion

    //region Navigation view

    /**
     * Gets the item selected from the navigation view and calls [navigate]
     * to change fragment
     */
    private fun selectItem(item: MenuItem): Boolean {
        val itemId = item.itemId

        drawer_layout.closeDrawer(GravityCompat.START)
        navigation_view.setCheckedItem(itemId)
        Handler().postDelayed({ navigate(itemId) }, NAVIGATION_DRAWER_DELAY)
        return true
    }

    /**
     * Chooses the right fragment to go to from the selected item id
     * in the navigation view
     */
    private fun navigate(id: Int) {
        val transaction = supportFragmentManager.beginTransaction()

        val fragment = when (id) {
            R.id.menu_main_pokemon -> findOrCreateFragment(PokemonFragment::class)
            else -> null
        }

        if (fragment != null)
            transaction.replace(R.id.content_frame, fragment)
        transaction.commit()
    }

    //endregion
}
