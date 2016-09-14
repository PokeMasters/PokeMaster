package it.lorenzorapetti.pokemaster.models.base

import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.ForeignKey
import com.raizlabs.android.dbflow.annotation.Index
import it.lorenzorapetti.pokemaster.models.Language

/**
 * Abstract model with id, flavor_text, language_id
 */
abstract class IsFlavorText() : HasId() {

    @ForeignKey
    @Index
    var language: Language? = null

    @Column(length = 500, name = "flavor_text")
    var flavorText: String = ""

}