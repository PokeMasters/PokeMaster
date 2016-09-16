package it.lorenzorapetti.pokemaster.models

import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.ForeignKey
import com.raizlabs.android.dbflow.annotation.Index
import com.raizlabs.android.dbflow.annotation.Table
import it.lorenzorapetti.pokemaster.db.PokedexDatabase
import it.lorenzorapetti.pokemaster.models.base.HasId

@Table(database = PokedexDatabase::class, name = "pokemon_v2_berryflavormap")
class BerryFlavorMap() : HasId() {

    @ForeignKey
    @Index
    var berry: Berry? = null

    @ForeignKey
    @Index
    var berryFlavor: BerryFlavor? = null

    @Column
    var potency: Int = 0

}