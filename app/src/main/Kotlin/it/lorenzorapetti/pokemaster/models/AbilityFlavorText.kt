package it.lorenzorapetti.pokemaster.models

import com.raizlabs.android.dbflow.annotation.ForeignKey
import com.raizlabs.android.dbflow.annotation.Index
import com.raizlabs.android.dbflow.annotation.Table
import it.lorenzorapetti.pokemaster.db.PokedexDatabase
import it.lorenzorapetti.pokemaster.models.base.IsFlavorText

@Table(database = PokedexDatabase::class, name = "pokemon_v2_abilityflavortext")
class AbilityFlavorText() : IsFlavorText() {

    @ForeignKey
    @Index
    var ability: Ability? = null

    @ForeignKey
    @Index
    var versionGroup: VersionGroup? = null

}