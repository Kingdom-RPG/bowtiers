package ru.kingdomrpg.bowtiers.item

import net.minecraft.item.BowItem
import net.minecraft.item.ItemStack


abstract class TieredBowItem(settings: Settings) : BowItem(settings) {


    override fun getEnchantability(): Int {
        return super.getEnchantability()
    }

    abstract fun getDamageBonus(): Double



    val powerDiv
        get() = 20f
}