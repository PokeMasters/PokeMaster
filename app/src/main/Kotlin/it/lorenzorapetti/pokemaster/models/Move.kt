package it.lorenzorapetti.pokemaster.models

import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.ForeignKey
import com.raizlabs.android.dbflow.annotation.Index
import com.raizlabs.android.dbflow.annotation.Table
import it.lorenzorapetti.pokemaster.db.PokedexDatabase
import it.lorenzorapetti.pokemaster.models.base.HasName

@Table(database = PokedexDatabase::class, name = "pokemon_v2_move")
class Move() : HasName() {

    @ForeignKey
    @Index
    var generation: Generation? = null

    @ForeignKey
    @Index
    var type: Type? = null

    @ForeignKey
    @Index
    var moveDamageClass: MoveDamageClass? = null

    @Column
    var power: Int? = null

    @Column
    var pp: Int? = null

    @Column
    var accuracy: Int? = null

    @Column
    var priority: Int? = null

    @Column(name = "move_effect_chance")
    var moveEffectChance: Int? = null

}