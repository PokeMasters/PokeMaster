package it.lorenzorapetti.pokemaster.models.view

import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.ModelView
import com.raizlabs.android.dbflow.annotation.ModelViewQuery
import com.raizlabs.android.dbflow.sql.Query
import com.raizlabs.android.dbflow.sql.queriable.StringQuery
import com.raizlabs.android.dbflow.structure.BaseModelView
import it.lorenzorapetti.pokemaster.db.PokedexDatabase
import it.lorenzorapetti.pokemaster.models.PokemonSpecies

@ModelView(database = PokedexDatabase::class)
class PokemonModelView : BaseModelView<PokemonSpecies>() {

    companion object {
        val STRING_QUERY = """
            SELECT pokemon_species.id, pokemon_species.name, pokemon_species.generation_id,
            (
                SELECT pf.name
                FROM pokemon_v2_pokemonform pf
                WHERE pf.pokemon_id = pokemon_species.id LIMIT 1
            ) as form_name,
            (
                SELECT p2pn.name
                FROM pokemon_v2_pokemonspeciesname p2pn
                WHERE p2pn.pokemon_species_id = pokemon_species.id
                AND p2pn.language_id = 9 LIMIT 1
            ) AS name_en,
            (
                SELECT p2pn.name
                FROM pokemon_v2_pokemonspeciesname p2pn
                WHERE p2pn.pokemon_species_id = pokemon_species.id
                AND p2pn.language_id = 8 LIMIT 1
            ) AS name_it,
            (
                SELECT p2t.name
                FROM pokemon_v2_type p2t
                INNER JOIN pokemon_v2_pokemontype p2pt ON p2pt.type_id = p2t.id
                WHERE p2pt.pokemon_id = pokemon_species.id
                AND p2pt.slot = 1
            ) AS primary_type_name,
            (
                SELECT p2t.name
                FROM pokemon_v2_type p2t
                INNER JOIN pokemon_v2_pokemontype p2pt ON p2pt.type_id = p2t.id
                WHERE p2pt.pokemon_id = pokemon_species.id
                AND p2pt.slot = 2
            ) AS secondary_type_name
            FROM pokemon_v2_pokemonspecies pokemon_species
        """

        @JvmField
        @ModelViewQuery
        val QUERY: Query = StringQuery<PokemonSpecies>(PokemonSpecies::class.java, STRING_QUERY)
    }

    @Column
    var id: Int = 0

    @Column
    var name: String = ""

    @Column(name = "form_name")
    var formName: String = ""

    @Column(name = "generation_id")
    var generationId: Int = 0

    @Column(name = "name_en")
    var nameEn: String = ""

    @Column(name = "name_it")
    var nameIt: String = ""

    @Column(name = "primary_type_name")
    var primaryTypeName: String = ""

    @Column(name = "secondary_type_name")
    var secondaryTypeName: String? = null

}