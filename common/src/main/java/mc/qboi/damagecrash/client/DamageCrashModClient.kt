package mc.qboi.damagecrash.client

import dev.architectury.event.events.client.ClientLifecycleEvent
import net.minecraft.client.Minecraft

object DamageCrashModClient {
    fun init() {
        ClientLifecycleEvent.CLIENT_SETUP.register(DamageCrashModClient::setup)
    }

    private fun setup(minecraft: Minecraft?) {
        // Do client setup here.
    }
}
