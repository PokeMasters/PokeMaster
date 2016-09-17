package it.lorenzorapetti.pokemaster.models

import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.ForeignKey
import com.raizlabs.android.dbflow.annotation.Index
import com.raizlabs.android.dbflow.annotation.Table
import it.lorenzorapetti.pokemaster.db.PokedexDatabase
import it.lorenzorapetti.pokemaster.models.base.HasId

@Table(database = PokedexDatabase::class, name = "pokemon_v2_encounterslot")
class EncounterSlot() : HasId() {

    @ForeignKey
    @Index
    var versionGroup: VersionGroup? = null

    @ForeignKey
    @Index
    var encounterMethod: EncounterMethod? = null

    @Column
    var slot: Int? = null

    @Column
    var rarity: Int = 0

}