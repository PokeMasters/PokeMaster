package it.lorenzorapetti.pokemaster.models

import com.raizlabs.android.dbflow.annotation.ForeignKey
import com.raizlabs.android.dbflow.annotation.Index
import com.raizlabs.android.dbflow.annotation.Table
import it.lorenzorapetti.pokemaster.db.PokedexDatabase
import it.lorenzorapetti.pokemaster.models.base.IsFlavorText

@Table(database = PokedexDatabase::class, name = "pokemon_v2_itemflavortext")
class ItemFlavorText() : IsFlavorText() {

    @ForeignKey
    @Index
    var item: Item? = null

    @ForeignKey
    @Index
    var versionGroup: VersionGroup? = null

}