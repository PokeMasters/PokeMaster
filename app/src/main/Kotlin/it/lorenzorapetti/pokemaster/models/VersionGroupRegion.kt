package it.lorenzorapetti.pokemaster.models

import com.raizlabs.android.dbflow.annotation.ForeignKey
import com.raizlabs.android.dbflow.annotation.Index
import com.raizlabs.android.dbflow.annotation.Table
import it.lorenzorapetti.pokemaster.db.PokedexDatabase
import it.lorenzorapetti.pokemaster.models.base.HasId

@Table(database = PokedexDatabase::class, name = "pokemon_v2_versiongroupregion")
class VersionGroupRegion() : HasId() {

    @ForeignKey
    @Index
    var region: Region? = null

    @ForeignKey
    @Index
    var versionGroup: VersionGroup? = null

}