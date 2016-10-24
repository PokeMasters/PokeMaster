package it.lorenzorapetti.pokemaster.views.fragment.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import it.lorenzorapetti.pokemaster.R
import kotlinx.android.synthetic.main.fragment_bottom_bar.*
import java.util.*

/**
 * A [Fragment] that implements the basic stuff to handle navigation with a [BottomBar]
 */
abstract class BaseBottomBarFragment(
        val layoutRes: Int? = null,
        val defaultTabPosition: Int = 0) : Fragment() {

    protected abstract val mFragments: HashMap<Int, Fragment>

    //region Fragment lifecycle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true

        //Check that the fragment list size is between 3 and 5 to be sure to follow
        //the Google Design Guidelines
        if (mFragments.size < 3 || mFragments.size > 5) {
            throw RuntimeException("""The fragments must be between 3 and 5 according to the
                                    Google Design Guidelines for the Bottom Navigation""")
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater!!.inflate(layoutRes ?: R.layout.fragment_bottom_bar, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (savedInstanceState == null) {
            bottomBar.setDefaultTabPosition(defaultTabPosition)
            initializeFragments()
        }

        bottomBar.setOnTabSelectListener { selectItem(it) }
    }

    //endregion

    //region Private methods

    private fun initializeFragments() {
        //Initialize all the fragments and hide them
        val transaction = childFragmentManager.beginTransaction()
        mFragments.forEach {
            transaction.add(R.id.content_frame, it.value, it.key.toString())
            if (it.key != bottomBar.currentTabId)
                transaction.hide(it.value)
        }
        transaction.commit()
    }

    private fun selectItem(itemId: Int) {
        if (mFragments.containsKey(itemId)) {
            val transaction = childFragmentManager.beginTransaction()
            mFragments.forEach {
                var f = childFragmentManager.findFragmentByTag(it.key.toString())
                if (f == null) f = it.value

                if (it.key != itemId) {
                    transaction.hide(f)
                } else {
                    transaction.show(f)
                }
            }
            transaction.commit()
        }
    }

    //endregion

}