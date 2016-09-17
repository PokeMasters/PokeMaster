package it.lorenzorapetti.pokemaster.models

import com.raizlabs.android.dbflow.annotation.ForeignKey
import com.raizlabs.android.dbflow.annotation.Index
import com.raizlabs.android.dbflow.annotation.Table
import it.lorenzorapetti.pokemaster.db.PokedexDatabase
import it.lorenzorapetti.pokemaster.models.base.HasId

@Table(database = PokedexDatabase::class, name = "pokemon_v2_encounterconditionvaluemap")
class EncounterConditionValueMap() : HasId() {

    @ForeignKey
    @Index
    var encounter: Encounter? = null

    @ForeignKey
    @Index
    var encounterConditionValue: EncounterConditionValue? = null

}