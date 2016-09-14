package it.lorenzorapetti.pokemaster.models.base

import com.raizlabs.android.dbflow.annotation.ForeignKey
import com.raizlabs.android.dbflow.annotation.Index
import it.lorenzorapetti.pokemaster.models.Language

/**
 * Abstract model with id, name and language.
 */
abstract class IsName() : HasName() {

    @ForeignKey
    @Index
    var language: Language? = null

}