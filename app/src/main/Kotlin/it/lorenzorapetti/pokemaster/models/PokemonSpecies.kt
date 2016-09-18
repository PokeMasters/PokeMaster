package it.lorenzorapetti.pokemaster.models

import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.ForeignKey
import com.raizlabs.android.dbflow.annotation.Index
import com.raizlabs.android.dbflow.annotation.Table
import it.lorenzorapetti.pokemaster.db.PokedexDatabase
import it.lorenzorapetti.pokemaster.models.base.HasName

@Table(database = PokedexDatabase::class, name = "pokemon_v2_pokemonspecies")
class PokemonSpecies() : HasName() {

    @ForeignKey
    @Index
    var generation: Generation? = null

    @ForeignKey
    @Index
    var pokemonColor: PokemonColor? = null

    @ForeignKey
    @Index
    var pokemonShape: PokemonShape? = null

    @ForeignKey
    @Index
    var growthRate: GrowthRate? = null

    @ForeignKey
    @Index
    var evolvesFromSpecies: PokemonSpecies? = null

    @ForeignKey
    @Index
    var evolutionChain: EvolutionChain? = null

    @Column(name = "gender_rate")
    var genderRate: Int = 0

    @Column(name = "capture_rate")
    var captureRate: Int = 0

    @Column(name = "base_happiness")
    var baseHappiness: Int = 0

    @Column(name = "is_baby")
    var isBaby: Boolean = false

    @Column(name = "hatch_counter")
    var hatchCounter: Int = 0

    @Column(name = "has_gender_differences",
            getterName = "getHasGenderDifferences",
            setterName = "setHasGenderDifferences")
    var hasGenderDifferences: Boolean = false

    @Column(name = "forms_switchable",
            getterName = "getFormsSwitchable",
            setterName = "setFormsSwitchable")
    var formsSwitchable: Boolean = false

    @Column
    var order: Int = 0

}