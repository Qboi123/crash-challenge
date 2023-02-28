package mc.qboi.damagecrash.fabric

import mc.qboi.damagecrash.DamageCrashMod
import net.fabricmc.api.ModInitializer

@Suppress("unused")
object DamageCrashFabric : ModInitializer {
    override fun onInitialize() {
        DamageCrashMod.init()
    }
}