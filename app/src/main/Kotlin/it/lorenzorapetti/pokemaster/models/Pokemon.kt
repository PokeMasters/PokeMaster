package it.lorenzorapetti.pokemaster.models

import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.ForeignKey
import com.raizlabs.android.dbflow.annotation.Index
import com.raizlabs.android.dbflow.annotation.Table
import it.lorenzorapetti.pokemaster.db.PokedexDatabase
import it.lorenzorapetti.pokemaster.models.base.HasName

@Table(database = PokedexDatabase::class, name = "pokemon_v2_pokemon")
class Pokemon() : HasName() {

    @ForeignKey
    @Index
    var pokemonSpecies: PokemonSpecies? = null

    @Column
    var height: Int = 0

    @Column
    var weight: Int = 0

    @Column(name = "base_experience")
    var baseExperience: Int = 0

    @Column(name = "is_default")
    var isDefault: Boolean = false

    @Column
    var order: Int = 0

}