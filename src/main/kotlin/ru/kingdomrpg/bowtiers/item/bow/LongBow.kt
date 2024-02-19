package ru.kingdomrpg.bowtiers.item.bow

import net.minecraft.item.Item
import ru.kingdomrpg.bowtiers.BowtiersConfig

class LongBow() : TieredBowItem(Item.Settings().maxDamage(650)) {
    override fun getDamageBonus(): Double {
        return BowtiersConfig.default.longbow.damageBonus
    }

    override fun getProjectileSpeedMultiplier(): Double {
        return BowtiersConfig.default.longbow.projectileSpeedModifier
    }
}