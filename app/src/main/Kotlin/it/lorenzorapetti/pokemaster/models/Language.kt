package it.lorenzorapetti.pokemaster.models

import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.Table
import it.lorenzorapetti.pokemaster.db.PokedexDatabase
import it.lorenzorapetti.pokemaster.models.base.HasName

@Table(database = PokedexDatabase::class, name = "pokemon_v2_language")
open class Language() : HasName() {

    @Column(length = 2)
    var iso639: String = ""

    @Column(length = 2)
    var iso3166: String = ""

    @Column(name = "official")
    var isOfficial: Boolean = false

    @Column
    var order: Int? = null

}