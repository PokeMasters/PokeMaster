package it.lorenzorapetti.pokemaster.models

import com.raizlabs.android.dbflow.annotation.ForeignKey
import com.raizlabs.android.dbflow.annotation.Index
import com.raizlabs.android.dbflow.annotation.Table
import it.lorenzorapetti.pokemaster.db.PokedexDatabase
import it.lorenzorapetti.pokemaster.models.base.IsFlavorText

@Table(database = PokedexDatabase::class, name = "pokemon_v2_pokemonspeciesflavortext")
class PokemonSpeciesFlavorText() : IsFlavorText() {

    @ForeignKey
    @Index
    var pokemonSpecies: PokemonSpecies? = null

    @ForeignKey
    @Index
    var version: Version? = null

}