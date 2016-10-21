package it.lorenzorapetti.pokemaster.utils

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import java.util.*
import kotlin.reflect.KClass
import kotlin.reflect.companionObject
import kotlin.reflect.memberProperties

/**
 * Searches the [Fragment] by its tag or, if it is null,
 * creates a new instance of it.
 * The [Fragment] class MUST have a static property named TAG
 *
 * @author Lorenzo Rapetti
 */
@Suppress("UNCHECKED_CAST")
@Throws(NoSuchElementException::class, IllegalAccessException::class, InstantiationException::class)
fun <T: Fragment> findOrCreateFragment(fragmentClass: KClass<T>,
                                       manager: FragmentManager, tag: String? = null): T? {
    try {
        val tagName = tag ?: fragmentClass.companionObject
                ?.memberProperties
                ?.first { it.name == "TAG" }
                ?.call(String::class) as? String
        val fragment = manager.findFragmentByTag(tagName) as? T

        return fragment ?: fragmentClass.java.newInstance()
    } catch (e: NoSuchElementException) {
        throw RuntimeException("The class ${fragmentClass.simpleName} must have a static field named TAG")
    } catch (e: IllegalAccessException) {
        throw RuntimeException("The class ${fragmentClass.simpleName} must have a public constructor")
    } catch (e: InstantiationException) {
        e.printStackTrace()
        return null
    }
}

/**
 * An extension function of the [AppCompatActivity] class that eliminates
 * the need of a [FragmentManager] parameter. It simply takes the [FragmentManager]
 * from the [AppCompatActivity] itself
 *
 * @author Lorenzo Rapetti
 */
fun <T: Fragment> AppCompatActivity.findOrCreateFragment(fragmentClass: KClass<T>, tag: String? = null) =
        findOrCreateFragment(fragmentClass, supportFragmentManager, tag)

/**
 * Get the resource identifier from the string and the type
 *
 * @author Lorenzo Rapetti
 */
fun Fragment.getResourceFromString(name: String, type: String) =
        resources.getIdentifier(name, type, context.packageName)

/**
 * The same as [getResourceFromString] but throws a RuntimeException if the resource was
 * not found
 *
 * @author Lorenzo Rapetti
 */
@Throws(RuntimeException::class)
fun Fragment.getResourceFromStringOrThrow(
        name: String,
        type: String,
        errorMessage: String = "Resource $name of type $type not found!"): Int {
    val res = getResourceFromString(name, type)
    if (res == 0) throw RuntimeException(errorMessage)
    return res
}

/**
 * Get an id resource from the name
 *
 * @author
 */
fun Fragment.getIdFromString(name: String) = getResourceFromString(name, "id")

/**
 * The same as [getIdFromString] but throws a RuntimeException if the resource was
 * not found
 */
@Throws(RuntimeException::class)
fun Fragment.getIdFromStringOrThrow(name: String) = getResourceFromStringOrThrow(name, "id")