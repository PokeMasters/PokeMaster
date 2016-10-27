package it.lorenzorapetti.pokemaster.models.base

import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.PrimaryKey
import com.raizlabs.android.dbflow.structure.BaseModel

/**
 * Abstract model with id only.
 * We will need this for almost every other model
 */
abstract class HasId() : BaseModel() {

    @PrimaryKey(autoincrement = true)
    @Column(name = "id",
            setterName = "setId",
            getterName = "getId")
    var id: Int = 0

}