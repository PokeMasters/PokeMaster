package it.lorenzorapetti.pokemaster.models

import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.ForeignKey
import com.raizlabs.android.dbflow.annotation.Index
import com.raizlabs.android.dbflow.annotation.Table
import it.lorenzorapetti.pokemaster.db.PokedexDatabase
import it.lorenzorapetti.pokemaster.models.base.HasId

@Table(database = PokedexDatabase::class, name = "pokemon_v2_encounter")
class Encounter() : HasId() {

    @ForeignKey
    @Index
    var version: Version? = null

    @ForeignKey
    @Index
    var locationArea: LocationArea? = null

    @ForeignKey
    @Index
    var encounterSlot: EncounterSlot? = null

    @Column
    var minLevel: Int = 0

    @Column
    var maxLevel: Int = 0

}