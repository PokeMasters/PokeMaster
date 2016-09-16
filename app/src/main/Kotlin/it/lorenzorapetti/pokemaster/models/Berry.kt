package it.lorenzorapetti.pokemaster.models

import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.ForeignKey
import com.raizlabs.android.dbflow.annotation.Index
import com.raizlabs.android.dbflow.annotation.Table
import it.lorenzorapetti.pokemaster.db.PokedexDatabase
import it.lorenzorapetti.pokemaster.models.base.HasName

@Table(database = PokedexDatabase::class, name = "pokemon_v2_berry")
class Berry() : HasName() {

    @ForeignKey
    @Index
    var item: Item? = null

    @ForeignKey
    @Index
    var berryFirmness: BerryFirmness? = null

    @ForeignKey
    @Index
    var naturalGiftType: Type? = null

    @Column(name = "natural_gift_power")
    var naturalGiftPower: Int = 0

    @Column
    var size: Int = 0

    @Column(name = "max_harvest")
    var maxHarvest: Int = 0

    @Column(name = "growth_time")
    var growthTime: Int = 0

    @Column(name = "soil_dryness")
    var soilDryness: Int = 0

    @Column
    var smoothness: Int = 0

}