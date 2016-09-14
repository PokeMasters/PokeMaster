package it.lorenzorapetti.pokemaster.models

import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.ForeignKey
import com.raizlabs.android.dbflow.annotation.Index
import com.raizlabs.android.dbflow.annotation.Table
import it.lorenzorapetti.pokemaster.db.PokedexDatabase
import it.lorenzorapetti.pokemaster.models.base.HasId

@Table(database = PokedexDatabase::class, name = "pokemon_v2_typeefficacy")
class TypeEfficacy() : HasId() {

    @ForeignKey
    @Index
    var damageType: Type? = null

    @ForeignKey
    @Index
    var targetType: Type? = null

    @Column(name = "damage_factor")
    var damageFactor: Int = 0

}