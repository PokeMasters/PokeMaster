package it.lorenzorapetti.pokemaster.models

import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.ForeignKey
import com.raizlabs.android.dbflow.annotation.Index
import com.raizlabs.android.dbflow.annotation.Table
import it.lorenzorapetti.pokemaster.db.PokedexDatabase
import it.lorenzorapetti.pokemaster.models.base.HasId

@Table(database = PokedexDatabase::class, name = "pokemon_v2_movemeta")
class MoveMeta() : HasId() {

    @ForeignKey
    @Index
    var moveMetaCategory: MoveMetaCategory? = null

    @ForeignKey
    @Index
    var move: Move? = null

    @Column(name = "min_hits")
    var minHits: Int? = null

    @Column(name = "max_hits")
    var maxHits: Int? = null

    @Column(name = "min_turns")
    var minTurns: Int? = null

    @Column(name = "max_turns")
    var maxTurns: Int? = null

    @Column
    var drain: Int? = null

    @Column
    var healing: Int? = null

    @Column(name = "crit_rate")
    var critRate: Int? = null

    @Column(name = "ailment_chance")
    var ailmentChance: Int? = null

    @Column(name = "flinch_chance")
    var flinchChance: Int? = null

    @Column(name = "stat_chance")
    var statChance: Int? = null

}