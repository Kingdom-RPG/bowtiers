package ru.kingdomrpg.bowtiers

import com.google.gson.Gson
import net.fabricmc.api.ModInitializer
import net.fabricmc.loader.api.FabricLoader
import org.slf4j.LoggerFactory
import ru.kingdomrpg.bowtiers.item.BowItems

object Bowtiers : ModInitializer {
    private val logger = LoggerFactory.getLogger("bowtiers")

    var config: BowtiersConfig = BowtiersConfig.default

    override fun onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.
        logger.info("Hello Fabric world!")
        loadConfig()
        BowItems.init()
    }

    private fun loadConfig() {

        val configPath = FabricLoader.getInstance().configDir.resolve("kingdomrpg-bowtiers.json")
        val configFile = configPath.toFile().also {
            if (it.createNewFile()) {
                it.writeText(Gson().toJson(BowtiersConfig.default))
            }
        }
        config = Gson().fromJson(configFile.readText(), BowtiersConfig::class.java)

    }
}