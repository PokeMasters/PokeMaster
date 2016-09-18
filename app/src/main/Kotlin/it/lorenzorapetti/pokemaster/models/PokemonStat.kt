package it.lorenzorapetti.pokemaster.models

import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.ForeignKey
import com.raizlabs.android.dbflow.annotation.Index
import com.raizlabs.android.dbflow.annotation.Table
import it.lorenzorapetti.pokemaster.db.PokedexDatabase
import it.lorenzorapetti.pokemaster.models.base.HasId

@Table(database = PokedexDatabase::class, name = "pokemon_v2_pokemonstat")
class PokemonStat() : HasId() {

    @ForeignKey
    @Index
    var pokemon: Pokemon? = null

    @ForeignKey
    @Index
    var stat: Stat? = null

    @Column(name = "base_stat")
    var baseStat: Int = 0

    @Column
    var effort: Int = 0

}