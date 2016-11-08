package it.lorenzorapetti.pokemaster.models.view

import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.ModelView
import com.raizlabs.android.dbflow.annotation.ModelViewQuery
import com.raizlabs.android.dbflow.sql.Query
import com.raizlabs.android.dbflow.sql.queriable.StringQuery
import com.raizlabs.android.dbflow.structure.BaseModelView
import it.lorenzorapetti.pokemaster.db.PokedexDatabase
import it.lorenzorapetti.pokemaster.models.PokemonForm
import it.lorenzorapetti.pokemaster.models.PokemonSpecies
import it.lorenzorapetti.pokemaster.utils.find
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

@ModelView(database = PokedexDatabase::class)
class PokemonModelView : BaseModelView<PokemonSpecies>() {

    companion object {
        val STRING_QUERY = """
            SELECT
            pokemon_species.id as pokemon_species_id,
            pokemon.id as pokemon_id,
            pokemon_form.id as form_id,
            pokemon_species.name,
            pokemon.name as pokemon_name,
            pokemon_form.name as form_name,
            pokemon_species.generation_id,
            pokemon_form.is_default as is_default_form,
            pokemon.is_default as is_default_pokemon,
            pokemon_form.is_favorite,
            pokemon_form.is_captured,
            (
                SELECT p2t.name
                FROM pokemon_v2_type p2t
                INNER JOIN pokemon_v2_pokemontype p2pt ON p2pt.type_id = p2t.id
                WHERE p2pt.pokemon_id = pokemon.id
                AND p2pt.slot = 1
            ) AS primary_type_name,
            (
                SELECT p2t.name
                FROM pokemon_v2_type p2t
                INNER JOIN pokemon_v2_pokemontype p2pt ON p2pt.type_id = p2t.id
                WHERE p2pt.pokemon_id = pokemon.id
                AND p2pt.slot = 2
            ) AS secondary_type_name
            FROM pokemon_v2_pokemonform pokemon_form
            LEFT JOIN pokemon_v2_pokemon pokemon ON pokemon.id = pokemon_form.pokemon_id
            LEFT JOIN pokemon_v2_pokemonspecies pokemon_species ON pokemon.pokemon_species_id = pokemon_species.id
            ORDER BY pokemon_species_id ASC, pokemon_id ASC, form_id ASC
        """

        @JvmField
        @ModelViewQuery
        val QUERY: Query = StringQuery<PokemonSpecies>(PokemonSpecies::class.java, STRING_QUERY)
    }

    @Column(name = "pokemon_species_id")
    var pokemonSpeciesId: Int = 0

    @Column(name = "pokemon_id")
    var pokemonId: Int = 0

    @Column(name = "form_id")
    var formId: Int = 0

    @Column
    var name: String = ""

    @Column(name = "pokemon_name")
    var pokemonName: String = ""

    @Column(name = "form_name")
    var formName: String = ""

    @Column(name = "generation_id")
    var generationId: Int = 0

    @Column(name = "is_default_form",
            getterName = "isDefaultForm")
    var isDefaultForm: Boolean = false

    @Column(name = "is_default_pokemon",
            getterName = "isDefaultPokemon")
    var isDefaultPokemon: Boolean = false

    @Column(name = "primary_type_name")
    var primaryTypeName: String = ""

    @Column(name = "secondary_type_name")
    var secondaryTypeName: String? = null

    @Column(name = "is_favorite",
            getterName = "isFavorite")
    var isFavorite: Boolean = false

    @Column(name = "is_captured",
            getterName = "isCaptured")
    var isCaptured: Boolean = false

    fun setIsDefaultPokemon(isDefault: Boolean) {
        isDefaultPokemon = isDefault
    }

    fun setIsDefaultForm(isDefault: Boolean) {
        isDefaultForm = isDefault
    }

    fun setIsFavorite(isFavorite: Boolean) {
        this.isFavorite = isFavorite
    }

    fun setIsCaptured(isCaptured: Boolean) {
        this.isCaptured = isCaptured
    }

    fun toggleFavorite(callback: (isFavorite: Boolean) -> Unit) {
        val pokemonForm = find(PokemonForm::class, formId)

        pokemonForm?.let {
            doAsync {
                pokemonForm.isFavorite = !isFavorite
                pokemonForm.update()
                this@PokemonModelView.isFavorite = pokemonForm.isFavorite
                uiThread {
                    callback(pokemonForm.isFavorite)
                }
            }
        }
    }

    fun toggleCaptured(callback: (isCaptured: Boolean) -> Unit) {
        val pokemonForm = find(PokemonForm::class, formId)

        pokemonForm?.let {
            doAsync {
                pokemonForm.isCaptured = !isCaptured
                pokemonForm.update()
                this@PokemonModelView.isCaptured = pokemonForm.isCaptured
                uiThread {
                    callback(pokemonForm.isCaptured)
                }
            }
        }
    }

    fun deleteFromFavorites(callback: () -> Unit) {
        val pokemonForm = find(PokemonForm::class, formId)

        pokemonForm?.let {
            doAsync {
                pokemonForm.isFavorite = false
                pokemonForm.update()
                this@PokemonModelView.isFavorite = pokemonForm.isFavorite
                uiThread {
                    callback()
                }
            }
        }
    }

    fun deleteFromCaptured(callback: () -> Unit) {
        val pokemonForm = find(PokemonForm::class, formId)

        pokemonForm?.let {
            doAsync {
                pokemonForm.isCaptured = false
                pokemonForm.update()
                this@PokemonModelView.isCaptured = pokemonForm.isCaptured
                uiThread {
                    callback()
                }
            }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (other !is PokemonModelView) return false
        return other.pokemonSpeciesId == pokemonSpeciesId &&
                other.pokemonId == pokemonId &&
                other.formId == formId
    }

}