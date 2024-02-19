package ru.kingdomrpg.bowtiers.item

import net.minecraft.item.Item
import net.minecraft.item.Items
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import ru.kingdomrpg.bowtiers.item.bow.LongBow
import ru.kingdomrpg.bowtiers.item.bow.NetherBow
import ru.kingdomrpg.bowtiers.item.bow.RecurveBow

object BowItems {

    // Tier1
    val RECURVE = createItem("recurve", RecurveBow())

    // Tier2
    val LONGBOW = createItem("longbow", LongBow())

    // Tier3
    val NETHERBOW = createItem("bow_haunted_bow", NetherBow())


    // Drop only
    val COTTON_YARN = createItem("cotton_yarn", Item(Item.Settings().maxCount(64)))

    val WITHER_YARN = createItem("wither_yarn", Item(Item.Settings().maxCount(64)))

    val PHANTOM_THREAD = createItem("phantom_thread", Item(Item.Settings().maxCount(64)))


    val BOWS = listOf(
        NETHERBOW,
        LONGBOW,
        RECURVE
    )


    private fun <T : Item> createItem(name: String, bow: T): T {
        return Registry.register(
            Registry.ITEM,
            Identifier("bowtiers", name),
            bow
        )
    }

    fun init() {
        Items.BOW
    }
}