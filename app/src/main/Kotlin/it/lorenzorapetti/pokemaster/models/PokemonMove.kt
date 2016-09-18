package it.lorenzorapetti.pokemaster.models

import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.ForeignKey
import com.raizlabs.android.dbflow.annotation.Index
import com.raizlabs.android.dbflow.annotation.Table
import it.lorenzorapetti.pokemaster.db.PokedexDatabase
import it.lorenzorapetti.pokemaster.models.base.HasId

@Table(database = PokedexDatabase::class, name = "pokemon_v2_pokemonmove")
class PokemonMove() : HasId() {

    @ForeignKey
    @Index
    var pokemon: Pokemon? = null

    @ForeignKey
    @Index
    var moveLearnMethod: MoveLearnMethod? = null

    @ForeignKey
    @Index
    var versionGroup: VersionGroup? = null

    @ForeignKey
    @Index
    var move: Move? = null

    @Column
    var level: Int = 0

    @Column
    var order: Int = 0

}