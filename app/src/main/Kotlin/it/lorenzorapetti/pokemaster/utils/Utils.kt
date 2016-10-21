package it.lorenzorapetti.pokemaster.utils

import android.support.v7.widget.RecyclerView
import com.raizlabs.android.dbflow.kotlinextensions.from
import com.raizlabs.android.dbflow.kotlinextensions.list
import com.raizlabs.android.dbflow.kotlinextensions.select
import com.raizlabs.android.dbflow.kotlinextensions.where
import com.raizlabs.android.dbflow.sql.language.property.IntProperty
import com.raizlabs.android.dbflow.structure.Model
import java.util.*
import kotlin.reflect.KClass
import kotlin.reflect.staticProperties

val cloudinaryUrl = "http://res.cloudinary.com/lorenzorapetti/image/upload/"
val sugimoriUrl = cloudinaryUrl + "sugimori/"
val sugimoriThumbUrl = "${cloudinaryUrl}t_thumb/sugimori/"

/**
 * Utils function for finding a record with an id.
 * Yes, i did all of this because i was annoyed to write the query every single time
 */
fun <T: Model> find(modelClass: KClass<T>, id: Int): T? {

    try {
        //We get the "id" property of the table class, if it exists
        val tableClass = Class.forName(modelClass.qualifiedName + "_Table").kotlin
        val idProperty: IntProperty? = tableClass.staticProperties.single {
            it.name == "id"
        } as? IntProperty

        if (idProperty != null) {
            //Finally we can search for the record
            return (select from modelClass where idProperty.eq(id)).querySingle() as? T
        }
    } catch (e: ClassNotFoundException) {
        e.printStackTrace()
    } catch (e: NoSuchElementException) {
        e.printStackTrace()
    }

    return null
}

/**
 * Return the count of records in a table
 */
fun <T: Model> count(modelClass: KClass<T>) = (select from modelClass).count().toInt()

/**
 * Get all the records of a table as a list
 */
fun <T: Model> getAll(modelClass: KClass<T>) = (select from modelClass).list

/**
 * Get all the records of a table as an [ArrayList]
 */
fun <T: Model> getAllAsArrayList(modelClass: KClass<T>) = getAll(modelClass) as? ArrayList<T>

/**
 * Utility function for the [RecyclerView.ViewHolder] that searches for a view by id
 */
fun RecyclerView.ViewHolder.viewById(id: Int) = itemView.findViewById(id)

fun String.getSugimoriUrl() = "${sugimoriUrl}sugimori_$this.png"

fun String.getSugimoriThumbUrl() = "${sugimoriThumbUrl}sugimori_$this.png"