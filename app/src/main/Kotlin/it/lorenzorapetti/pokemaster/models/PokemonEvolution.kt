package it.lorenzorapetti.pokemaster.models

import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.ForeignKey
import com.raizlabs.android.dbflow.annotation.Index
import com.raizlabs.android.dbflow.annotation.Table
import it.lorenzorapetti.pokemaster.db.PokedexDatabase
import it.lorenzorapetti.pokemaster.models.base.HasId

@Table(database = PokedexDatabase::class, name = "pokemon_v2_pokemonevolution")
class PokemonEvolution() : HasId() {

    @ForeignKey
    @Index
    var evolutionTrigger: EvolutionTrigger? = null

    @ForeignKey
    @Index
    var evolutionItem: Item? = null

    @ForeignKey
    @Index
    var evolvedSpecies: PokemonSpecies? = null

    @ForeignKey
    @Index
    var location: Location? = null

    @ForeignKey
    @Index
    var heldItem: Item? = null

    @ForeignKey
    @Index
    var knownMove: Move? = null

    @ForeignKey
    @Index
    var knownMoveType: Type? = null

    @ForeignKey
    @Index
    var partySpecies: PokemonSpecies? = null

    @ForeignKey
    @Index
    var partyType: Type? = null

    @ForeignKey
    @Index
    var tradeSpecies: PokemonSpecies? = null

    @Column(name = "min_level")
    var minLevel: Int = 0

    @Column(name = "time_of_day", length = 10)
    var timeOfDay: String? = null

    @Column(name = "min_happiness")
    var minHappiness: Int? = null

    @Column(name = "min_beauty")
    var minBeauty: Int? = null

    @Column(name = "min_affection")
    var minAffection: Int? = null

    @Column(name = "relative_physical_stats")
    var relativePhysicalStats: Int? = null

    @Column(name = "needs_overworld_rain",
            getterName = "getNeedsOverworldRain",
            setterName = "setNeedsOverworldRain")
    var needsOverworldRain: Boolean = false

    @Column(name = "turn_upside_down",
            getterName = "getTurnUpsideDown",
            setterName = "setTurnUpsideDown")
    var turnUpsideDown: Boolean = false

    @Column(name = "gender_id")
    var genderId: Int? = null

}