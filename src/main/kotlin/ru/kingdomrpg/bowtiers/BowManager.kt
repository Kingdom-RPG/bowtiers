package ru.kingdomrpg.bowtiers

import net.minecraft.entity.projectile.PersistentProjectileEntity
import net.minecraft.item.BowItem
import ru.kingdomrpg.bowtiers.item.bow.TieredBowItem

object BowManager {


    fun modifyBowDamage(
        bow: BowItem,
        projectile: PersistentProjectileEntity
    ) {

        when (bow) {
            is TieredBowItem -> {
                projectile.damage = projectile.damage + bow.getDamageBonus()
            }

            else -> {
                projectile.damage = projectile.damage + BowtiersConfig.default.vanilla.damageBonus
            }
        }

    }

    fun modifyProjectileSpeed(bow: BowItem, projectile: PersistentProjectileEntity) {
        val multiplier = when (bow) {
            is TieredBowItem -> {
                bow.getProjectileSpeedMultiplier()
            }

            else -> {
                1.0
            }
        }

        projectile.velocity = projectile.velocity.multiply(multiplier)

    }
}