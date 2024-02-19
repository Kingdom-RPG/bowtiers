package ru.kingdomrpg.bowtiers

import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import ru.kingdomrpg.bowtiers.item.NetherBow
import ru.kingdomrpg.bowtiers.item.TieredBowItem

object Items {

    val NETHERBOW = createBow("netherbow", NetherBow())


    val BOWS = listOf(
        NETHERBOW
    )


    private fun createBow(name: String, bow: TieredBowItem): TieredBowItem {
        return Registry.register(
            Registry.ITEM,
            Identifier("bowtiers", name),
            bow
        )
    }

    fun init() {

    }
}