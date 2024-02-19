package ru.kingdomrpg.bowtiers

import net.fabricmc.api.ClientModInitializer
import net.minecraft.client.item.ModelPredicateProviderRegistry
import net.minecraft.client.item.UnclampedModelPredicateProvider
import net.minecraft.util.Identifier
import org.slf4j.LoggerFactory
import ru.kingdomrpg.bowtiers.item.bow.TieredBowItem

object BowtiersClient : ClientModInitializer {
    private val logger = LoggerFactory.getLogger("bowtiers")

    private val PULL = Identifier("pull")
    private val PULLING = Identifier("pulling")


    private val PULL_PROVIDER =
        UnclampedModelPredicateProvider { stack, world, entity, seed -> if (entity == null) 0.0f else if (entity.activeItem !== stack) 0.0f else (stack.maxUseTime - entity.itemUseTimeLeft) / (stack.item as TieredBowItem).powerDiv }
    private val PULLING_PROVIDER =
        UnclampedModelPredicateProvider { stack, world, entity, seed -> if (entity != null && entity.isUsingItem && entity.activeItem === stack) 1.0f else 0.0f }


    override fun onInitializeClient() {
        BowItems.BOWS.forEach { bow ->
            ModelPredicateProviderRegistry.register(
                bow,
                PULL,
                PULL_PROVIDER
            )

            ModelPredicateProviderRegistry.register(
                bow,
                PULLING,
                PULLING_PROVIDER
            )
        }
    }
}