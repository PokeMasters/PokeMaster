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

        val language = find(Language::class, 9)
        assert(language?.id == 9)
        assert(language?.name == "en")
        assert(language?.iso639 == "en")
        assert(language?.iso3166 == "us")
        assert(language?.isOfficial == true)
        assert(language?.order == 6)
    }

    @Test
    @Throws(Exception::class)
    fun languageNameTable_shouldExist() {
        assert(count(LanguageName::class) == 40)

        val languageName = find(LanguageName::class, 36)
        assert(languageName?.id == 36)
        assert(languageName?.name == "English")
        assert(languageName?.language?.id == 9)
        assert(languageName?.localLanguage?.id == 9)
    }

    //endregion

    //region VERSION

    @Test
    @Throws(Exception::class)
    fun versionTable_shouldExist() {
        assert(count(Version::class) == 26)

        val version = find(Version::class, 26)
        assert(version?.id == 26)
        assert(version?.name == "alpha-sapphire")
        assert(version?.versionGroup?.id == 16)
    }

    @Test
    @Throws(Exception::class)
    fun versionNameTable_shouldExist() {
        assert(count(VersionName::class) == 130)

        val versionName = find(VersionName::class, 130)
        assert(versionName?.id == 130)
        assert(versionName?.name == "Alpha Sapphire")
        assert(versionName?.version?.id == 26)
        assert(versionName?.language?.id == 9)
    }

    @Test
    @Throws(Exception::class)
    fun versionGroupTable_shouldExist() {
        assert(count(VersionGroup::class) == 16)

        val versionGroup = find(VersionGroup::class, 16)
        assert(versionGroup?.id == 16)
        assert(versionGroup?.name == "omega-ruby-alpha-sapphire")
        assert(versionGroup?.generation?.id == 6)
        assert(versionGroup?.order == 16)
    }

    //endregion

    //region GENERATION

    @Test
    @Throws(Exception::class)
    fun generationTable_shouldExist() {
        assert(count(Generation::class) == 6)

        val generation = find(Generation::class, 6)
        assert(generation?.id == 6)
        assert(generation?.name == "generation-vi")
        assert(generation?.region?.id == 6)
    }

    @Test
    @Throws(Exception::class)
    fun generationNameTable_shouldExist() {
        assert(count(GenerationName::class) == 18)

        val generationName = find(GenerationName::class, 18)
        assert(generationName?.id == 18)
        assert(generationName?.name == "Generation VI")
        assert(generationName?.generation?.id == 6)
        assert(generationName?.language?.id == 9)
    }

    //endregion

    //region REGION

    @Test
    @Throws(Exception::class)
    fun regionTable_shouldExist() {
        assert(count(Region::class) == 6)

        val region = find(Region::class, 6)
        assert(region?.id == 6)
        assert(region?.name == "kalos")
    }

    @Test
    @Throws(Exception::class)
    fun regionNameTable_shouldExist() {
        assert(count(RegionName::class) == 30)

        val regionName = find(RegionName::class, 30)
        assert(regionName?.id == 30)
        assert(regionName?.name == "Kalos")
        assert(regionName?.region?.id == 6)
        assert(regionName?.language?.id == 9)
    }

    //endregion

    //region ABILITY

    @Test
    @Throws(Exception::class)
    fun abilityTable_shouldExist() {
        assert(count(Ability::class) == 251)

        val ability = find(Ability::class, 191)
        assert(ability?.id == 191)
        assert(ability?.name == "delta-stream")
        assert(ability?.isMainSeries == true)
        assert(ability?.generation?.id == 6)
    }

    @Test
    @Throws(Exception::class)
    fun abilityEffectTextTable_shouldExist() {
        assert(count(AbilityEffectText::class) == 191)

        val abilityEffectText = find(AbilityEffectText::class, 188)
        assert(abilityEffectText?.id == 188)
        assert(abilityEffectText?.shortEffect == "Makes dark aura and fairy aura weaken moves of their respective types.")
        assert(abilityEffectText?.effect == "While this Pokémon is on the field, dark aura and fairy aura weaken moves of their respective types to 2/3 their power, rather than strengthening them.")
        assert(abilityEffectText?.ability?.id == 188)
        assert(abilityEffectText?.language?.id == 9)
    }

    @Test
    @Throws(Exception::class)
    fun abilityFlavorTextTable_shouldExist() {
        assert(count(AbilityFlavorText::class) == 4121)

        val abilityFlavorText = find(AbilityFlavorText::class, 551)
        assert(abilityFlavorText?.id == 551)
        assert(abilityFlavorText?.flavorText == "Prevents the foe’s escape.")
        assert(abilityFlavorText?.ability?.id == 23)
        assert(abilityFlavorText?.versionGroup?.id == 5)
        assert(abilityFlavorText?.language?.id == 9)
    }

    @Test
    @Throws(Exception::class)
    fun abilityNameTable_shouldExist() {
        assert(count(AbilityName::class) == 1397)

        val abilityName = find(AbilityName::class, 523)
        assert(abilityName?.id == 523)
        assert(abilityName?.name == "Caparazón")
        assert(abilityName?.ability?.id == 75)
        assert(abilityName?.language?.id == 7)
    }

    //endregion

    //region TYPE

    @Test
    @Throws(Exception::class)
    fun typeTable_shouldExist() {
        assert(count(Type::class) == 20)

        val type = find(Type::class, 9)
        assert(type?.id == 9)
        assert(type?.name == "steel")
        assert(type?.generation?.id == 2)
        assert(type?.moveDamageClass?.id == 2)
    }

    @Test
    @Throws(Exception::class)
    fun typeNameTable_shouldExist() {
        assert(count(TypeName::class) == 137)

        val typeName = find(TypeName::class, 104)
        assert(typeName?.id == 104)
        assert(typeName?.name == "Ghiaccio")
        assert(typeName?.language?.id == 8)
        assert(typeName?.type?.id == 15)
    }

    @Test
    @Throws(Exception::class)
    fun typeEfficacyTable_shouldExist() {
        assert(count(TypeEfficacy::class) == 324)

        val typeEfficacy = find(TypeEfficacy::class, 97)
        assert(typeEfficacy?.id == 97)
        assert(typeEfficacy?.damageFactor == 200)
        assert(typeEfficacy?.damageType?.id == 6)
        assert(typeEfficacy?.targetType?.id == 7)
    }

    //endregion

    //region STAT

    @Test
    @Throws(Exception::class)
    fun statTable_shouldExist() {
        assert(count(Stat::class) == 8)

        val stat = find(Stat::class, 4)
        assert(stat?.id == 4)
        assert(stat?.name == "special-attack")
        assert(stat?.isBattleOnly == false)
        assert(stat?.gameIndex == 5)
        assert(stat?.moveDamageClass?.id == 3)
    }

    @Test
    @Throws(Exception::class)
    fun statNameTable_shouldExist() {
        assert(count(StatName::class) == 48)

        val statName = find(StatName::class, 32)
        assert(statName?.id == 32)
        assert(statName?.name == "Vitesse")
        assert(statName?.language?.id == 5)
        assert(statName?.stat?.id == 6)
    }

    //endregion

}