package it.lorenzorapetti.pokemaster.models

import com.raizlabs.android.dbflow.annotation.ForeignKey
import com.raizlabs.android.dbflow.annotation.Index
import com.raizlabs.android.dbflow.annotation.Table
import it.lorenzorapetti.pokemaster.db.PokedexDatabase
import it.lorenzorapetti.pokemaster.models.base.HasEffectAndShortEffect

@Table(database = PokedexDatabase::class, name = "pokemon_v2_moveeffecteffecttext")
class MoveEffectEffectText() : HasEffectAndShortEffect() {

    @ForeignKey
    @Index
    var moveEffect: MoveEffect? = null

}