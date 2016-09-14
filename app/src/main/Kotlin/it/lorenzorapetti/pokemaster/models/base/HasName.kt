package it.lorenzorapetti.pokemaster.models.base

import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.Index

/**
 * Abstract model with id and name.
 * The column "name" is an identifier for a lot of models
 */
abstract class HasName() : HasId() {

    @Column
    @Index
    var name: String = ""

}