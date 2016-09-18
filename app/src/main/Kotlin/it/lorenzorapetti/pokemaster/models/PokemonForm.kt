package it.lorenzorapetti.pokemaster.models

import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.ForeignKey
import com.raizlabs.android.dbflow.annotation.Index
import com.raizlabs.android.dbflow.annotation.Table
import it.lorenzorapetti.pokemaster.db.PokedexDatabase
import it.lorenzorapetti.pokemaster.models.base.HasName

@Table(database = PokedexDatabase::class, name = "pokemon_v2_pokemonform")
class PokemonForm() : HasName() {

    @ForeignKey
    @Index
    var pokemon: Pokemon? = null

    @ForeignKey
    @Index
    var versionGroup: VersionGroup? = null

    @Column(name = "form_name", length = 30)
    var formName: String = ""

    @Column(name = "is_default")
    var isDefault: Boolean = false

    @Column(name = "is_battle_only")
    var isBattleOnly: Boolean = false

    @Column(name = "is_mega")
    var isMega: Boolean = false

    @Column(name = "form_order")
    var formOrder: Int? = null

    @Column
    var order: Int = 0

}