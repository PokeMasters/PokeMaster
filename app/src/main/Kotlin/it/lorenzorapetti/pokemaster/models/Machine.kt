package it.lorenzorapetti.pokemaster.models

import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.ForeignKey
import com.raizlabs.android.dbflow.annotation.Index
import com.raizlabs.android.dbflow.annotation.Table
import it.lorenzorapetti.pokemaster.db.PokedexDatabase
import it.lorenzorapetti.pokemaster.models.base.HasId

@Table(database = PokedexDatabase::class, name = "pokemon_v2_machine")
class Machine() : HasId() {

    @ForeignKey
    @Index
    var growthRate: GrowthRate? = null

    @ForeignKey
    @Index
    var item: Item? = null

    @ForeignKey
    @Index
    var versionGroup: VersionGroup? = null

    @ForeignKey
    @Index
    var move: Move? = null

    @Column(name = "machine_number")
    var machineNumber: Int = 0

}