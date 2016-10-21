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
            initializeFragments()
        }

        bottomBar.setDefaultTabPosition(defaultTabPosition)
        bottomBar.setOnTabSelectListener { selectItem(it) }
    }

    //endregion

    //region Private methods

    private fun initializeFragments() {
        //Initialize all the fragments and hide them
        val transaction = childFragmentManager.beginTransaction()
        mFragments.forEach {
            transaction.add(R.id.content_frame, it.value, it.key.toString())
            transaction.hide(it.value)
        }
        transaction.commit()
    }

    private fun selectItem(itemId: Int) {
        if (mFragments.containsKey(itemId)) {
            val transaction = childFragmentManager.beginTransaction()
            mFragments.forEach {
                if (it.key != itemId) {
                    transaction.hide(it.value)
                } else {
                    transaction.show(it.value)
                }
            }
            transaction.commit()
        }
    }

    //endregion

}