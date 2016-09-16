package it.lorenzorapetti.pokemaster.models

import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.ForeignKey
import com.raizlabs.android.dbflow.annotation.Index
import com.raizlabs.android.dbflow.annotation.Table
import it.lorenzorapetti.pokemaster.db.PokedexDatabase
import it.lorenzorapetti.pokemaster.models.base.HasName

@Table(database = PokedexDatabase::class, name = "pokemon_v2_item")
class Item() : HasName() {

    @ForeignKey
    @Index
    var itemCategory: ItemCategory? = null

    @ForeignKey
    @Index
    var itemFlingEffect: ItemFlingEffect? = null

    @Column
    var cost: Int? = null

    @Column(name = "fling_power")
    var flingPower: Int? = null

}