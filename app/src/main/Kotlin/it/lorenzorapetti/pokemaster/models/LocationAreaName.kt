package it.lorenzorapetti.pokemaster.models

import com.raizlabs.android.dbflow.annotation.ForeignKey
import com.raizlabs.android.dbflow.annotation.Index
import com.raizlabs.android.dbflow.annotation.Table
import it.lorenzorapetti.pokemaster.db.PokedexDatabase
import it.lorenzorapetti.pokemaster.models.base.IsName

@Table(database = PokedexDatabase::class, name = "pokemon_v2_locationareaname")
class LocationAreaName() : IsName() {

    @ForeignKey
    @Index
    var locationArea: LocationArea? = null

}