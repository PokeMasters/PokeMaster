package it.lorenzorapetti.pokemaster.utls

import com.raizlabs.android.dbflow.kotlinextensions.from
import com.raizlabs.android.dbflow.kotlinextensions.list
import com.raizlabs.android.dbflow.kotlinextensions.select
import com.raizlabs.android.dbflow.kotlinextensions.where
import com.raizlabs.android.dbflow.sql.language.property.IntProperty
import com.raizlabs.android.dbflow.structure.Model
import java.util.*
import kotlin.reflect.KClass
import kotlin.reflect.staticProperties

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
 * Return the count of the records in a table
 */
fun <T: Model> count(modelClass: KClass<T>) = (select from modelClass).list.size