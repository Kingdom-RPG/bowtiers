package ru.kingdomrpg.bowtiers.item.bow

import ru.kingdomrpg.bowtiers.BowtiersConfig

class NetherBow : TieredBowItem(Settings().fireproof().maxDamage(1200)) {
    override fun getDamageBonus(): Double {
        return BowtiersConfig.default.haunted.damageBonus
    }

    override fun getProjectileSpeedMultiplier(): Double {
        return BowtiersConfig.default.haunted.projectileSpeedModifier
    }
}