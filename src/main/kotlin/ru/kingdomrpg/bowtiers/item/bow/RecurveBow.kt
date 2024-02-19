package ru.kingdomrpg.bowtiers.item.bow

import net.minecraft.item.Item
import ru.kingdomrpg.bowtiers.BowtiersConfig

class RecurveBow() : TieredBowItem(Item.Settings().maxDamage(650)) {
    override fun getDamageBonus(): Double {
        return BowtiersConfig.default.recurve.damageBonus
    }

    override fun getProjectileSpeedMultiplier(): Double {
        return BowtiersConfig.default.recurve.projectileSpeedModifier
    }
}