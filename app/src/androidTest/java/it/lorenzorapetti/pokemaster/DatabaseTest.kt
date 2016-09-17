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

    //region ENCOUNTER

    @Test
    @Throws(Exception::class)
    fun encounterMethodTable_shouldExist() {
        assert(count(EncounterMethod::class) == 17)

        val encounterMethod = find(EncounterMethod::class, 7)
        assert(encounterMethod?.id == 7)
        assert(encounterMethod?.name == "headbutt")
        assert(encounterMethod?.order == 17)
    }

    @Test
    @Throws(Exception::class)
    fun encounterMethodNameTable_shouldExist() {
        assert(count(EncounterMethodName::class) == 34)

        val encounterMethodName = find(EncounterMethodName::class, 3)
        assert(encounterMethodName?.id == 3)
        assert(encounterMethodName?.name == "Mit einer normalen Angel angeln")
        assert(encounterMethodName?.encounterMethod?.id == 2)
        assert(encounterMethodName?.language?.id == 6)
    }

    @Test
    @Throws(Exception::class)
    fun encounterSlotTable_shouldExist() {
        assert(count(EncounterSlot::class) == 489)

        val encounterSlot = find(EncounterSlot::class, 251)
        assert(encounterSlot?.id == 251)
        assert(encounterSlot?.slot == 1)
        assert(encounterSlot?.rarity == 40)
        assert(encounterSlot?.encounterMethod?.id == 4)
        assert(encounterSlot?.versionGroup?.id == 11)
    }

    @Test
    @Throws(Exception::class)
    fun encounterTable_shouldExist() {
        assert(count(Encounter::class) == 46530)

        val encounter = find(Encounter::class, 1)
        assert(encounter?.id == 7)
        assert(encounter?.minLevel == 20)
        assert(encounter?.maxLevel == 30)
        assert(encounter?.locationArea?.id == 1)
        assert(encounter?.version?.id == 12)
        assert(encounter?.encounterSlot?.id == 28)
    }

    @Test
    @Throws(Exception::class)
    fun encounterConditionTable_shouldExist() {
        assert(count(EncounterCondition::class) == 6)

        val encounterCondition = find(EncounterCondition::class, 3)
        assert(encounterCondition?.id == 3)
        assert(encounterCondition?.name == "radar")
    }

    @Test
    @Throws(Exception::class)
    fun encounterConditionNameTable_shouldExist() {
        assert(count(EncounterConditionName::class) == 18)

        val encounterConditionName = find(EncounterConditionName::class, 9)
        assert(encounterConditionName?.id == 9)
        assert(encounterConditionName?.name == "PokeRadar")
        assert(encounterConditionName?.encounterCondition?.id == 3)
        assert(encounterConditionName?.language?.id == 9)
    }

    @Test
    @Throws(Exception::class)
    fun encounterConditionValueTable_shouldExist() {
        assert(count(EncounterConditionValue::class) == 20)

        val encounterConditionValue = find(EncounterConditionValue::class, 10)
        assert(encounterConditionValue?.id == 10)
        assert(encounterConditionValue?.name == "slot2-sapphire")
        assert(encounterConditionValue?.encounterCondition?.id == 4)
        assert(encounterConditionValue?.isDefault == false)
    }

    @Test
    @Throws(Exception::class)
    fun encounterConditionValueNameTable_shouldExist() {
        assert(count(EncounterConditionValueName::class) == 40)

        val encounterConditionValueName = find(EncounterConditionValueName::class, 20)
        assert(encounterConditionValueName?.id == 20)
        assert(encounterConditionValueName?.name == "Sapphire in slot 2")
        assert(encounterConditionValueName?.encounterConditionValue?.id == 10)
        assert(encounterConditionValueName?.language?.id == 9)
    }

    @Test
    @Throws(Exception::class)
    fun encounterConditionValueMapTable_shouldExist() {
        assert(count(EncounterConditionValueMap::class) == 12175)

        val encounterConditionValueMap = find(EncounterConditionValueMap::class, 6578)
        assert(encounterConditionValueMap?.id == 6578)
        assert(encounterConditionValueMap?.encounter?.id == 17452)
        assert(encounterConditionValueMap?.encounterConditionValue?.id == 16)
    }

    //endregion

    //region MOVE

    @Test
    @Throws(Exception::class)
    fun moveTable_shouldExist() {
        assert(count(Move::class) == 639)

        val move = find(Move::class, 350)
        assert(move?.id == 350)
        assert(move?.name == "rock-blast")
        assert(move?.power == 25)
        assert(move?.pp == 10)
        assert(move?.accuracy == 90)
        assert(move?.priority == 0)
        assert(move?.moveEffectChance == null)
        assert(move?.generation?.id == 3)
        assert(move?.moveDamageClass?.id == 2)
        assert(move?.type?.id == 6)
    }

    @Test
    @Throws(Exception::class)
    fun moveNameTable_shouldExist() {
        assert(count(MoveName::class) == 4451)

        val moveName = find(MoveName::class, 4451)
        assert(moveName?.id == 4451)
        assert(moveName?.name == "Shadow Sky")
        assert(moveName?.move?.id == 10018)
        assert(moveName?.language?.id == 9)
    }

    @Test
    @Throws(Exception::class)
    fun moveFlavorTextTable_shouldExist() {
        assert(count(MoveFlavorText::class) == 14546)

        val moveFlavorText = find(MoveFlavorText::class, 1)
        assert(moveFlavorText?.id == 1)
        assert(moveFlavorText?.flavorText == """Pounds with fore­
                legs or tail.""")
        assert(moveFlavorText?.move?.id == 1)
        assert(moveFlavorText?.language?.id == 9)
        assert(moveFlavorText?.versionGroup?.id == 3)
    }

    //endregion

    //region MOVE DAMAGE CLASS

    @Test
    @Throws(Exception::class)
    fun moveDamageClassTable_shouldExist() {
        assert(count(MoveDamageClass::class) == 3)

        val moveDamageClass = find(MoveDamageClass::class, 1)
        assert(moveDamageClass?.id == 1)
        assert(moveDamageClass?.name == "status")
    }

    @Test
    @Throws(Exception::class)
    fun moveDamageClassNameTable_shouldExist() {
        assert(count(MoveDamageClassName::class) == 12)

        val moveDamageClassName = find(MoveDamageClassName::class, 5)
        assert(moveDamageClassName?.id == 5)
        assert(moveDamageClassName?.name == "ぶつり")
        assert(moveDamageClassName?.moveDamageClass?.id == 2)
        assert(moveDamageClassName?.language?.id == 1)
    }

    //endregion

    //region MOVE EFFECT

    @Test
    @Throws(Exception::class)
    fun moveEffectTable_shouldExist() {
        assert(count(MoveEffect::class) == 356)

        val moveEffect = find(MoveEffect::class, 237)
        assert(moveEffect?.id == 237)
    }

    @Test
    @Throws(Exception::class)
    fun moveEffectEffectTextTable_shouldExist() {
        assert(count(MoveEffectEffectText::class) == 356)

        val moveEffectEffectText = find(MoveEffectEffectText::class, 237)
        assert(moveEffectEffectText?.id == 237)
        assert(moveEffectEffectText?.effect == """Inflicts regular damage.  User dives underwater for one turn, becoming immune to attack, and hits on the second turn.

                During the immune turn, surf, and whirlpool still hit the user normally, and their power is doubled if appropriate.

                The user may be hit during its immune turn if under the effect of lock on, mind reader, or no guard.

                This move cannot be selected by sleep talk.""")
        assert(moveEffectEffectText?.shortEffect == "User dives underwater, dodging all attacks, and hits next turn.")
        assert(moveEffectEffectText?.language?.id == 9)
        assert(moveEffectEffectText?.moveEffect?.id == 256)
    }

    //endregion

    //region MOVE META

    @Test
    @Throws(Exception::class)
    fun moveMetaTable_shouldExist() {
        assert(count(MoveMeta::class) == 617)

        val moveMeta = find(MoveMeta::class, 100)
        assert(moveMeta?.id == 100)
        assert(moveMeta?.minHits == null)
        assert(moveMeta?.maxHits == null)
        assert(moveMeta?.minTurns == null)
        assert(moveMeta?.maxTurns == null)
        assert(moveMeta?.critRate == 0)
        assert(moveMeta?.ailmentChance == 0)
        assert(moveMeta?.flinchChance == 0)
        assert(moveMeta?.statChance == 0)
        assert(moveMeta?.drain == 0)
        assert(moveMeta?.healing == 0)
        assert(moveMeta?.moveMetaCategory?.id == 13)
        assert(moveMeta?.move?.id == 100)
    }

    @Test
    @Throws(Exception::class)
    fun moveMetaCategoryTable_shouldExist() {
        assert(count(MoveMetaCategory::class) == 14)

        val moveMetaCategory = find(MoveMetaCategory::class, 10)
        assert(moveMetaCategory?.id == 10)
        assert(moveMetaCategory?.name == "whole-field-effect")
    }

    //endregion

    //region MACHINE

    @Test
    @Throws(Exception::class)
    fun machineTable_shouldExist() {
        assert(count(Machine::class) == 1228)

        val machine = find(Machine::class, 3)
        assert(machine?.id == 3)
        assert(machine?.machineNumber == 1)
        assert(machine?.move?.id == 223)
        assert(machine?.versionGroup?.id == 3)
        assert(machine?.item?.id == 305)
        assert(machine?.growthRate?.id == null)
    }

    //endregion

}