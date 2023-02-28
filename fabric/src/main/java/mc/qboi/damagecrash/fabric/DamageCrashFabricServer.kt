package mc.qboi.damagecrash.fabric

import mc.qboi.damagecrash.server.DamageCrashModServer
import net.fabricmc.api.DedicatedServerModInitializer

@Suppress("unused")
object DamageCrashFabricServer : DedicatedServerModInitializer {
    override fun onInitializeServer() {
        DamageCrashModServer.init()
    }
}