package ru.kingdomrpg.bowtiers


data class BowConfiguration(
    val damageBonus: Double,
    val projectileSpeedModifier: Double
)

data class BowtiersConfig(
    val vanilla: BowConfiguration,
    val recurve: BowConfiguration,
    val longbow: BowConfiguration,
    val haunted: BowConfiguration
) {
    companion object {
        val default = BowtiersConfig(
            BowConfiguration(-1.0, .8),
            BowConfiguration(0.0, 1.1),
            BowConfiguration(0.5, 1.5),
            BowConfiguration(1.0, 1.8),
        )
    }
}