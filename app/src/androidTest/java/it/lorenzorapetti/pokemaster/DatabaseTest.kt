package it.lorenzorapetti.pokemaster

import android.support.test.runner.AndroidJUnit4
import com.raizlabs.android.dbflow.config.DatabaseDefinition
import com.raizlabs.android.dbflow.config.FlowManager
import it.lorenzorapetti.pokemaster.db.PokedexDatabase
import it.lorenzorapetti.pokemaster.models.*
import it.lorenzorapetti.pokemaster.utls.count
import it.lorenzorapetti.pokemaster.utls.find
import org.junit.BeforeClass

import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
open class DatabaseTest {

    companion object {

        var db: DatabaseDefinition? = null

        @BeforeClass
        fun before() {
            db = FlowManager.getDatabase(PokedexDatabase::class.java)
        }

    }

    //region LANGUAGE

    @Test
    @Throws(Exception::class)
    fun languageTable_shouldExist() {
        assert(count(Language::class) == 11)
        assert(find(Language::class, 9)?.name == "en")
    }

    @Test
    @Throws(Exception::class)
    fun languageNameTable_shouldExist() {
        assert(count(LanguageName::class) == 40)

        val lang = find(LanguageName::class, 36)
        assert(lang?.name == "English")
        assert(lang?.localLanguage?.name == "en")
    }

    //endregion

    //region VERSION

    @Test
    @Throws(Exception::class)
    fun versionTable_shouldExist() {
        assert(count(Version::class) == 26)

        val version = find(Version::class, 26)
        assert(version?.name == "alpha-sapphire")
        assert(version?.versionGroup?.name == "omega-ruby-alpha-sapphire")
    }

    @Test
    @Throws(Exception::class)
    fun versionNameTable_shouldExist() {
        assert(count(VersionName::class) == 130)

        val versionName = find(VersionName::class, 130)
        assert(versionName?.name == "Alpha Sapphire")
        assert(versionName?.version?.name == "alpha-sapphire")
        assert(versionName?.language?.name == "en")
    }

    @Test
    @Throws(Exception::class)
    fun versionGroupTable_shouldExist() {
        assert(count(VersionGroup::class) == 16)

        val versionGroup = find(VersionGroup::class, 16)
        assert(versionGroup?.name == "omega-ruby-alpha-sapphire")
        assert(versionGroup?.generation?.name == "generation-vi")
    }

    //endregion

    //region GENERATION

    @Test
    @Throws(Exception::class)
    fun generationTable_shouldExist() {
        assert(count(Generation::class) == 6)

        val generation = find(Generation::class, 6)
        assert(generation?.name == "generation-vi")
        assert(generation?.region?.name == "kalos")
    }

    @Test
    @Throws(Exception::class)
    fun generationNameTable_shouldExist() {
        assert(count(GenerationName::class) == 18)

        val generationName = find(GenerationName::class, 18)
        assert(generationName?.name == "Generation VI")
        assert(generationName?.generation?.name == "generation-vi")
    }

    //endregion

    //region REGION

    @Test
    @Throws(Exception::class)
    fun regionTable_shouldExist() {
        assert(count(Region::class) == 6)

        val generation = find(Region::class, 6)
        assert(generation?.name == "kalos")
    }

    @Test
    @Throws(Exception::class)
    fun regionNameTable_shouldExist() {
        assert(count(RegionName::class) == 30)

        val regionName = find(RegionName::class, 30)
        assert(regionName?.name == "Kalos")
        assert(regionName?.region?.name == "kalos")
    }

    //endregion

}