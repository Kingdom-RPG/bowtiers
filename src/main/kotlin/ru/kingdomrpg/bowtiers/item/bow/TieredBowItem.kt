package ru.kingdomrpg.bowtiers.item.bow

import net.minecraft.item.BowItem


abstract class TieredBowItem(settings: Settings) : BowItem(settings) {


    override fun getEnchantability(): Int {
        return super.getEnchantability()
    }

    abstract fun getDamageBonus(): Double

    abstract fun getProjectileSpeedMultiplier(): Double


    val powerDiv
        get() = 20f
}