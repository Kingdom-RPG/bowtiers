package ru.kingdomrpg.bowtiers

import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback
import net.minecraft.client.item.ModelPredicateProviderRegistry
import net.minecraft.client.item.UnclampedModelPredicateProvider
import net.minecraft.text.Style
import net.minecraft.text.Text
import net.minecraft.util.Formatting
import net.minecraft.util.Identifier
import org.slf4j.LoggerFactory
import ru.kingdomrpg.bowtiers.item.BowItems
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
        bowModelStuff()

        loreTooltips()


    }


    private fun loreTooltips() {
        ItemTooltipCallback.EVENT.register { stack, ctx, line ->

            when (stack.item) {
                BowItems.COTTON_YARN, BowItems.WITHER_YARN, BowItems.PHANTOM_THREAD -> {
                    line.add(Text.translatable("lore.bowtiers.${stack.item}")
                        .styled { Style.EMPTY.withColor(Formatting.DARK_PURPLE).withItalic(true) })
                }
            }


        }
    }

    private fun bowModelStuff() {
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