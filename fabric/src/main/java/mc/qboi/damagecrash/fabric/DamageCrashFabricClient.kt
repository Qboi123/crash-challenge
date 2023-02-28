package mc.qboi.damagecrash.fabric

import mc.qboi.damagecrash.client.DamageCrashModClient
import net.fabricmc.api.ClientModInitializer

@Suppress("unused")
object DamageCrashFabricClient : ClientModInitializer {
    override fun onInitializeClient() {
        DamageCrashModClient.init()
    }
}