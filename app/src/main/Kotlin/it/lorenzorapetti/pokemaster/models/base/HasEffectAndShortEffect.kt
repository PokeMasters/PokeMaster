package it.lorenzorapetti.pokemaster.models.base

import com.raizlabs.android.dbflow.annotation.Column

/**
 * Abstract model with id, effect, short_effect, language_id
 */
abstract class HasEffectAndShortEffect() : HasEffect() {

    @Column(length = 300, name = "short_effect")
    var shortEffect: String = ""

}