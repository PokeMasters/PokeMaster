package it.lorenzorapetti.pokemaster.models.base

import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.ForeignKey
import com.raizlabs.android.dbflow.annotation.Index
import it.lorenzorapetti.pokemaster.models.Language

/**
 * Abstract model with id, effect, language_id
 */
abstract class HasEffect() : HasId() {

    @ForeignKey
    @Index
    var language: Language? = null

    @Column(length = 6000)
    var effect: String = ""

}