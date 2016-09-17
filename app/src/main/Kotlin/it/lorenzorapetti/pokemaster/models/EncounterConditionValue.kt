package it.lorenzorapetti.pokemaster.models

import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.ForeignKey
import com.raizlabs.android.dbflow.annotation.Index
import com.raizlabs.android.dbflow.annotation.Table
import it.lorenzorapetti.pokemaster.db.PokedexDatabase
import it.lorenzorapetti.pokemaster.models.base.HasName

@Table(database = PokedexDatabase::class, name = "pokemon_v2_encounterconditionvalue")
class EncounterConditionValue() : HasName() {

    @ForeignKey
    @Index
    var encounterCondition: EncounterCondition? = null

    @Column(name = "is_default")
    var isDefault: Boolean = false

}