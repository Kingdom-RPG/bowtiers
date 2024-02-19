package ru.kingdomrpg.bowtiers

import com.mojang.brigadier.CommandDispatcher
import com.mojang.brigadier.context.CommandContext
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback
import net.fabricmc.loader.api.FabricLoader
import net.minecraft.command.CommandRegistryAccess
import net.minecraft.server.command.CommandManager
import net.minecraft.server.command.CommandManager.RegistrationEnvironment
import net.minecraft.server.command.ServerCommandSource
import org.slf4j.LoggerFactory

object Bowtiers : ModInitializer {
    private val logger = LoggerFactory.getLogger("bowtiers")

    override fun onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.
        logger.info("Hello Fabric world!")
        BowItems.init()
        Compat.init()



        CommandRegistrationCallback.EVENT.register(CommandRegistrationCallback { dispatcher: CommandDispatcher<ServerCommandSource?>, dedicated: CommandRegistryAccess?, environment: RegistrationEnvironment? ->
            dispatcher.register(
                CommandManager.literal("kek")
                    .executes { commandContext: CommandContext<ServerCommandSource?> ->
                        debug()


                        1
                    }
            )
        })
    }

    private fun debug() {

        println(FabricLoader.getInstance().isModLoaded("levelz"))
//        println(LevelLists.bowList)
//        println(LevelLists.armorList)
//        println(LevelLists.customItemList)


//        PlayerStatsManager.playerLevelisHighEnough(user, levelList, string, true)


//        if(!LevelLists.customItemList.contains("bowtiers:netherbow")) {
//            println("adding")
//            LevelLists.customItemList.add("bowtiers:netherbow")
//            LevelLists.customItemList.add("archery")
//            LevelLists.customItemList.add(4)
//        }

//        if(!LevelLists.customItemList.contains("bowtiers:netherbow")) {
//            println("adding")
//            LevelLists.customItemList.add("bowtiers:netherbow")
//            LevelLists.customItemList.add("archery")
//            LevelLists.customItemList.add(4)
//        }
    }
}