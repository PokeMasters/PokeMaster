package it.lorenzorapetti.pokemaster.models

import com.raizlabs.android.dbflow.annotation.ForeignKey
import com.raizlabs.android.dbflow.annotation.Index
import com.raizlabs.android.dbflow.annotation.Table
import it.lorenzorapetti.pokemaster.db.PokedexDatabase
import it.lorenzorapetti.pokemaster.models.base.HasName

@Table(database = PokedexDatabase::class, name = "pokemon_v2_type")
class Type() : HasName() {

    @ForeignKey
    @Index
    var generation: Generation? = null

    @ForeignKey
    @Index
    var moveDamageClass: MoveDamageClass? = null

}