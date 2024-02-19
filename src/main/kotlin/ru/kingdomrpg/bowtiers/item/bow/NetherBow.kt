package ru.kingdomrpg.bowtiers.item.bow

class NetherBow : TieredBowItem(Settings().fireproof().maxDamage(1200)) {
    override fun getDamageBonus(): Double {
        return 2.0
    }
}