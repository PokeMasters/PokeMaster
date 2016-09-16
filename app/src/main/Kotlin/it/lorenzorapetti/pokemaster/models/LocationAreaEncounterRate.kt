package it.lorenzorapetti.pokemaster.models

import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.ForeignKey
import com.raizlabs.android.dbflow.annotation.Index
import com.raizlabs.android.dbflow.annotation.Table
import it.lorenzorapetti.pokemaster.db.PokedexDatabase
import it.lorenzorapetti.pokemaster.models.base.HasId

@Table(database = PokedexDatabase::class, name = "pokemon_v2_locationareaencounterrate")
class LocationAreaEncounterRate() : HasId() {

    @ForeignKey
    @Index
    var encounterMethod: EncounterMethod? = null

    @ForeignKey
    @Index
    var locationArea: LocationArea? = null

    @ForeignKey
    @Index
    var version: Version? = null

    @Column
    var rate: Int = 0

}