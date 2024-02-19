package ru.kingdomrpg.bowtiers.item

import net.minecraft.item.Item

class NetherBow() : TieredBowItem(Item.Settings().fireproof().maxDamage(1200)) {
    override fun getDamageBonus(): Double {
        return 2.0
    }
}