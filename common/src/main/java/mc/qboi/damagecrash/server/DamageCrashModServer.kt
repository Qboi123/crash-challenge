package mc.qboi.damagecrash.server

import dev.architectury.event.events.common.LifecycleEvent

object DamageCrashModServer {
    fun init() {
        LifecycleEvent.SETUP.register(DamageCrashModServer::setup)
    }

    private fun setup() {
        // Do server setup here.
    }
}
