package it.lorenzorapetti.pokemaster

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.raizlabs.android.dbflow.config.FlowManager
import it.lorenzorapetti.pokemaster.db.PokedexDatabase

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        FlowManager.getWritableDatabase(PokedexDatabase::class.java)
    }
}
