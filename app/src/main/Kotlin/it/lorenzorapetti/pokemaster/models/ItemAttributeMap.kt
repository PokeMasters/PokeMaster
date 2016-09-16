package it.lorenzorapetti.pokemaster.models

import com.raizlabs.android.dbflow.annotation.ForeignKey
import com.raizlabs.android.dbflow.annotation.Index
import com.raizlabs.android.dbflow.annotation.Table
import it.lorenzorapetti.pokemaster.db.PokedexDatabase
import it.lorenzorapetti.pokemaster.models.base.HasId

@Table(database = PokedexDatabase::class, name = "pokemon_v2_itemattributemap")
class ItemAttributeMap() : HasId() {

    @ForeignKey
    @Index
    var item: Item? = null

    @ForeignKey
    @Index
    var itemAttribute: ItemAttribute? = null

}