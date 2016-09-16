package it.lorenzorapetti.pokemaster.models

import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.ForeignKey
import com.raizlabs.android.dbflow.annotation.Index
import com.raizlabs.android.dbflow.annotation.Table
import it.lorenzorapetti.pokemaster.db.PokedexDatabase
import it.lorenzorapetti.pokemaster.models.base.HasName

@Table(database = PokedexDatabase::class, name = "pokemon_v2_nature")
class Nature() : HasName() {

    @ForeignKey
    @Index
    var decreasedStat: Stat? = null

    @ForeignKey
    @Index
    var increasedStat: Stat? = null

    @ForeignKey
    @Index
    var hatesFlavor: BerryFlavor? = null

    @ForeignKey
    @Index
    var likesFlavor: BerryFlavor? = null

    @Column(name = "game_index")
    var gameIndex: Int = 0

}