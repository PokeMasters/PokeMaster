package it.lorenzorapetti.pokemaster

import android.support.test.runner.AndroidJUnit4
import it.lorenzorapetti.pokemaster.models.*
import it.lorenzorapetti.pokemaster.utls.count
import it.lorenzorapetti.pokemaster.utls.find

import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
open class DatabaseTest {

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

    //region CHARACTERISTIC

    @Test
    @Throws(Exception::class)
    fun characteristicTable_shouldExist() {
        assert(count(Characteristic::class) == 30)

        val characteristic = find(Characteristic::class, 10)
        assert(characteristic?.id == 10)
        assert(characteristic?.geneMod5 == 1)
        assert(characteristic?.stat?.id == 4)
    }

    @Test
    @Throws(Exception::class)
    fun characteristicDescriptionTable_shouldExist() {
        assert(count(CharacteristicDescription::class) == 60)

        val characteristicDescription = find(CharacteristicDescription::class, 22)
        assert(characteristicDescription?.id == 22)
        assert(characteristicDescription?.description == "Somewhat vain")
        assert(characteristicDescription?.characteristic?.id == 11)
        assert(characteristicDescription?.language?.id == 9)
    }

    //endregion

    //region EGG GROUP

    @Test
    @Throws(Exception::class)
    fun eggGroupTable_shouldExist() {
        assert(count(EggGroup::class) == 15)

        val eggGroup = find(EggGroup::class, 9)
        assert(eggGroup?.id == 9)
        assert(eggGroup?.name == "water3")
    }

    @Test
    @Throws(Exception::class)
    fun eggGroupNameTable_shouldExist() {
        assert(count(RegionName::class) == 90)

        val eggGroupName = find(EggGroupName::class, 45)
        assert(eggGroupName?.id == 45)
        assert(eggGroupName?.name == "Humanotyp")
        assert(eggGroupName?.eggGroup?.id == 8)
        assert(eggGroupName?.language?.id == 6)
    }

    //endregion

    //region ITEM

    @Test
    @Throws(Exception::class)
    fun itemPocketTable_shouldExist() {
        assert(count(ItemPocket::class) == 8)

        val itemPocket = find(ItemPocket::class, 2)
        assert(itemPocket?.id == 2)
        assert(itemPocket?.name == "medicine")
    }

    @Test
    @Throws(Exception::class)
    fun itemPocketNameTable_shouldExist() {
        assert(count(ItemPocketName::class) == 8)

        val itemPocketName = find(ItemPocketName::class, 1)
        assert(itemPocketName?.id == 1)
        assert(itemPocketName?.name == "Items")
        assert(itemPocketName?.itemPocket?.id == 1)
        assert(itemPocketName?.language?.id == 9)
    }

    @Test
    @Throws(Exception::class)
    fun itemCategoryTable_shouldExist() {
        assert(count(ItemCategory::class) == 44)

        val itemCategory = find(ItemCategory::class, 12)
        assert(itemCategory?.id == 12)
        assert(itemCategory?.name == "held-items")
        assert(itemCategory?.itemPocket?.id == 1)
    }

    @Test
    @Throws(Exception::class)
    fun itemCategoryNameTable_shouldExist() {
        assert(count(ItemCategoryName::class) == 44)

        val itemCategoryName = find(ItemCategoryName::class, 20)
        assert(itemCategoryName?.id == 20)
        assert(itemCategoryName?.name == "Event items")
        assert(itemCategoryName?.itemCategory?.id == 20)
        assert(itemCategoryName?.language?.id == 9)
    }

    @Test
    @Throws(Exception::class)
    fun itemFlingEffectTable_shouldExist() {
        assert(count(ItemFlingEffect::class) == 7)

        val itemFlingEffect = find(ItemFlingEffect::class, 5)
        assert(itemFlingEffect?.id == 5)
        assert(itemFlingEffect?.name == "paralyze")
    }

    @Test
    @Throws(Exception::class)
    fun itemFlingEffectEffectTextTable_shouldExist() {
        assert(count(ItemFlingEffectEffectText::class) == 7)

        val itemFlingEffectEffectText = find(ItemFlingEffectEffectText::class, 1)
        assert(itemFlingEffectEffectText?.id == 1)
        assert(itemFlingEffectEffectText?.effect == "Badly poisons the target.")
        assert(itemFlingEffectEffectText?.itemFlingEffect?.id == 1)
        assert(itemFlingEffectEffectText?.language?.id == 9)
    }

    @Test
    @Throws(Exception::class)
    fun itemTable_shouldExist() {
        assert(count(Item::class) == 746)

        val item = find(Item::class, 562)
        assert(item?.id == 562)
        assert(item?.name == "old-sea-map")
        assert(item?.cost == 0)
        assert(item?.flingPower == null)
        assert(item?.itemCategory?.id == 20)
        assert(item?.itemFlingEffect?.id == null)
    }

    @Test
    @Throws(Exception::class)
    fun itemEffectTextTable_shouldExist() {
        assert(count(ItemEffectText::class) == 678)

        val itemEffectText = find(ItemEffectText::class, 669)
        assert(itemEffectText?.id == 669)
        assert(itemEffectText?.effect == "")
        assert(itemEffectText?.shortEffect == "Holds medals recieved in the medal rally.")
        assert(itemEffectText?.item?.id == 670)
        assert(itemEffectText?.language?.id == 9)
    }

    @Test
    @Throws(Exception::class)
    fun itemNameTable_shouldExist() {
        assert(count(ItemName::class) == 5156)

        val itemName = find(ItemName::class, 1375)
        assert(itemName?.id == 1375)
        assert(itemName?.name == "ぎんのこな")
        assert(itemName?.item?.id == 199)
        assert(itemName?.language?.id == 1)
    }

    @Test
    @Throws(Exception::class)
    fun itemFlavorTextTable_shouldExist() {
        assert(count(ItemFlavorText::class) == 9604)

        val itemFlavorText = find(ItemFlavorText::class, 3577)
        assert(itemFlavorText?.id == 3577)
        assert(itemFlavorText?.flavorText == """Strumento da dare a un Pokémon.
                Sciarpa raffinata che potenzia le mosse
                di tipo Normale.""")
        assert(itemFlavorText?.item?.id == 228)
        assert(itemFlavorText?.language?.id == 8)
        assert(itemFlavorText?.versionGroup?.id == 15)
    }

    @Test
    @Throws(Exception::class)
    fun itemAttributeTable_shouldExist() {
        assert(count(ItemAttribute::class) == 8)

        val itemAttribute = find(ItemAttribute::class, 5)
        assert(itemAttribute?.id == 5)
        assert(itemAttribute?.name == "holdable")
    }

    @Test
    @Throws(Exception::class)
    fun itemAttributeNameTable_shouldExist() {
        assert(count(ItemAttributeName::class) == 8)

        val itemAttributeName = find(ItemAttributeName::class, 2)
        assert(itemAttributeName?.id == 2)
        assert(itemAttributeName?.name == "Consumable")
        assert(itemAttributeName?.itemAttribute?.id == 2)
        assert(itemAttributeName?.language?.id == 9)
    }

    @Test
    @Throws(Exception::class)
    fun itemAttributeMapTable_shouldExist() {
        assert(count(ItemAttributeMap::class) == 611)

        val itemAttributeMap = find(ItemAttributeMap::class, 314)
        assert(itemAttributeMap?.id == 314)
        assert(itemAttributeMap?.item?.id == 69)
        assert(itemAttributeMap?.itemAttribute?.id == 1)
    }

    //endregion

    //region BERRY

    @Test
    @Throws(Exception::class)
    fun berryFirmnessTable_shouldExist() {
        assert(count(BerryFirmness::class) == 5)

        val berryFirmness = find(BerryFirmness::class, 1)
        assert(berryFirmness?.id == 1)
        assert(berryFirmness?.name == "very-soft")
    }

    @Test
    @Throws(Exception::class)
    fun berryFirmnessNameTable_shouldExist() {
        assert(count(BerryFirmnessName::class) == 10)

        val berryFirmnessName = find(BerryFirmnessName::class, 5)
        assert(berryFirmnessName?.id == 5)
        assert(berryFirmnessName?.name == "Ferme")
        assert(berryFirmnessName?.berryFirmness?.id == 3)
        assert(berryFirmnessName?.language?.id == 5)
    }

    @Test
    @Throws(Exception::class)
    fun berryTable_shouldExist() {
        assert(count(Berry::class) == 64)

        val berry = find(Berry::class, 40)
        assert(berry?.id == 40)
        assert(berry?.name == "yache")
        assert(berry?.naturalGiftPower == 60)
        assert(berry?.size == 135)
        assert(berry?.maxHarvest == 5)
        assert(berry?.growthTime == 18)
        assert(berry?.soilDryness == 6)
        assert(berry?.smoothness == 30)
        assert(berry?.berryFirmness?.id == 4)
        assert(berry?.item?.id == 165)
        assert(berry?.naturalGiftType?.id == 15)
    }

    @Test
    @Throws(Exception::class)
    fun berryFlavorTable_shouldExist() {
        assert(count(BerryFlavor::class) == 5)

        val berryFlavor = find(BerryFlavor::class, 3)
        assert(berryFlavor?.id == 3)
        assert(berryFlavor?.name == "sweet")
    }

    @Test
    @Throws(Exception::class)
    fun berryFlavorNameTable_shouldExist() {
        assert(count(BerryFlavorName::class) == 10)

        val berryFlavorName = find(BerryFlavorName::class, 4)
        assert(berryFlavorName?.id == 4)
        assert(berryFlavorName?.name == "Dry")
        assert(berryFlavorName?.berryFlavor?.id == 2)
        assert(berryFlavorName?.language?.id == 9)
    }

    @Test
    @Throws(Exception::class)
    fun berryFlavorMapTable_shouldExist() {
        assert(count(BerryFlavorMap::class) == 320)

        val berryFlavorMap = find(BerryFlavorMap::class, 150)
        assert(berryFlavorMap?.id == 150)
        assert(berryFlavorMap?.potency == 20)
        assert(berryFlavorMap?.berry?.id == 30)
        assert(berryFlavorMap?.berryFlavor?.id == 5)
    }

    //endregion

    //region GROWTH RATE

    @Test
    @Throws(Exception::class)
    fun growthRateTable_shouldExist() {
        assert(count(GrowthRate::class) == 6)

        val growthRate = find(GrowthRate::class, 2)
        assert(growthRate?.id == 2)
        assert(growthRate?.name == "medium")
        assert(growthRate?.formula == "x^3")
    }

    @Test
    @Throws(Exception::class)
    fun growthRateDescriptionTable_shouldExist() {
        assert(count(GrowthRateDescription::class) == 18)

        val growthRateDescription = find(GrowthRateDescription::class, 6)
        assert(growthRateDescription?.id == 6)
        assert(growthRateDescription?.description == "medium")
        assert(growthRateDescription?.growthRate?.id == 2)
        assert(growthRateDescription?.language?.id == 9)
    }

    //endregion

    //region NATURE

    @Test
    @Throws(Exception::class)
    fun natureTable_shouldExist() {
        assert(count(Nature::class) == 25)

        val nature = find(Nature::class, 10)
        assert(nature?.id == 2)
        assert(nature?.name == "hasty")
        assert(nature?.gameIndex == 11)
        assert(nature?.hatesFlavor?.id == 5)
        assert(nature?.likesFlavor?.id == 3)
        assert(nature?.decreasedStat?.id == 3)
        assert(nature?.increasedStat?.id == 6)
    }

    @Test
    @Throws(Exception::class)
    fun natureNameTable_shouldExist() {
        assert(count(NatureName::class) == 175)

        val natureName = find(NatureName::class, 50)
        assert(natureName?.id == 50)
        assert(natureName?.name == "おっとり")
        assert(natureName?.nature?.id == 8)
        assert(natureName?.language?.id == 1)
    }

    //endregion

    //region LOCATION

    @Test
    @Throws(Exception::class)
    fun locationTable_shouldExist() {
        assert(count(Location::class) == 678)

        val location = find(Location::class, 56)
        assert(location?.id == 56)
        assert(location?.name == "sinnoh-route-228")
        assert(location?.region?.id == 4)
    }

    @Test
    @Throws(Exception::class)
    fun locationNameTable_shouldExist() {
        assert(count(LocationName::class) == 2101)

        val locationName = find(LocationName::class, 1456)
        assert(locationName?.id == 1456)
        assert(locationName?.name == "リビエールライン")
        assert(locationName?.location?.id == 610)
        assert(locationName?.language?.id == 1)
    }

    @Test
    @Throws(Exception::class)
    fun locationAreaTable_shouldExist() {
        assert(count(LocationArea::class) == 716)

        val locationArea = find(LocationArea::class, 350)
        assert(locationArea?.id == 350)
        assert(locationArea?.name == "petalburg-city-area")
        assert(locationArea?.location?.id == 429)
        assert(locationArea?.gameIndex == 0)
    }

    @Test
    @Throws(Exception::class)
    fun locationAreaNameTable_shouldExist() {
        assert(count(LocationAreaName::class) == 684)

        val locationAreaName = find(LocationAreaName::class, 235)
        assert(locationAreaName?.id == 350)
        assert(locationAreaName?.name == "")
        assert(locationAreaName?.locationArea?.id == 278)
        assert(locationAreaName?.language?.id == 9)
    }

    @Test
    @Throws(Exception::class)
    fun locationAreaEncounterRateTable_shouldExist() {
        assert(count(LocationAreaEncounterRate::class) == 3865)

        val locationAreaEncounterRate = find(LocationAreaEncounterRate::class, 3600)
        assert(locationAreaEncounterRate?.id == 3600)
        assert(locationAreaEncounterRate?.rate == 8)
        assert(locationAreaEncounterRate?.locationArea?.id == 649)
        assert(locationAreaEncounterRate?.version?.id == 17)
        assert(locationAreaEncounterRate?.encounterMethod?.id == 1)
    }

    //endregion

}