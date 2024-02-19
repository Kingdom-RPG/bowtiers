package ru.kingdomrpg.bowtiers.item.bow

import net.minecraft.item.Item

class RecurveBow() : TieredBowItem(Item.Settings().maxDamage(650)) {
    override fun getDamageBonus(): Double {
        return 2.0
    }
}