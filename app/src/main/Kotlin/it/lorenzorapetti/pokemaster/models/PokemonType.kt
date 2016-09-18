package it.lorenzorapetti.pokemaster.models

import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.ForeignKey
import com.raizlabs.android.dbflow.annotation.Index
import com.raizlabs.android.dbflow.annotation.Table
import it.lorenzorapetti.pokemaster.db.PokedexDatabase
import it.lorenzorapetti.pokemaster.models.base.HasId

@Table(database = PokedexDatabase::class, name = "pokemon_v2_pokemontype")
class PokemonType() : HasId() {

    @ForeignKey
    @Index
    var pokemon: Pokemon? = null

    @ForeignKey
    @Index
    var type: Type? = null

    @Column
    var slot: Int = 0

}