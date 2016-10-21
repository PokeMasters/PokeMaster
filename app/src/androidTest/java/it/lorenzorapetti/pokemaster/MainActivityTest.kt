package it.lorenzorapetti.pokemaster

import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import it.lorenzorapetti.pokemaster.views.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
open class MainActivityTest {

    @Rule
    @JvmField
    var activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    @Throws(Exception::class)
    fun toolbar_shouldShowTitle() {

    }

}