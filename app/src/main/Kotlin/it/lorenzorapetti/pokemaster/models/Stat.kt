package it.lorenzorapetti.pokemaster.models

import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.ForeignKey
import com.raizlabs.android.dbflow.annotation.Index
import com.raizlabs.android.dbflow.annotation.Table
import it.lorenzorapetti.pokemaster.db.PokedexDatabase
import it.lorenzorapetti.pokemaster.models.base.HasName

@Table(database = PokedexDatabase::class, name = "pokemon_v2_stat")
class Stat() : HasName() {

    @Column(name = "is_battle_only")
    var isBattleOnly: Boolean = false

    @Column
    var gameIndex: Int = 0

    @ForeignKey
    @Index
    var moveDamageClass: MoveDamageClass? = null

}