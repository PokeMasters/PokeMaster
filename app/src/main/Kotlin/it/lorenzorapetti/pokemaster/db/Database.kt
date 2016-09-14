package it.lorenzorapetti.pokemaster.db

import com.raizlabs.android.dbflow.annotation.Database

@Database(name = PokedexDatabase.DB_NAME, version = PokedexDatabase.DB_VERSION)
class PokedexDatabase {

    companion object {
        const val DB_NAME = "pokedex"
        const val DB_VERSION = 1
    }

}