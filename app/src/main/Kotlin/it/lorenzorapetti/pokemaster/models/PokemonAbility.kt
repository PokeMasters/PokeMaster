package it.lorenzorapetti.pokemaster.models

import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.ForeignKey
import com.raizlabs.android.dbflow.annotation.Index
import com.raizlabs.android.dbflow.annotation.Table
import it.lorenzorapetti.pokemaster.db.PokedexDatabase
import it.lorenzorapetti.pokemaster.models.base.HasId

@Table(database = PokedexDatabase::class, name = "pokemon_v2_pokemonability")
class PokemonAbility() : HasId() {

    @ForeignKey
    @Index
    var pokemon: Pokemon? = null

    @ForeignKey
    @Index
    var ability: Ability? = null

    @Column(name = "is_hidden")
    var isHidden: Boolean = false

    @Column
    var slot: Int = 0

}