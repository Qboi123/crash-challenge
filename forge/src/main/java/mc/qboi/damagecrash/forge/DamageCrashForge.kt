@file:Suppress("removal")

package mc.qboi.damagecrash.forge

import mc.qboi.damagecrash.DamageCrashMod
import mc.qboi.damagecrash.client.DamageCrashModClient
import mc.qboi.damagecrash.server.DamageCrashModServer
import dev.architectury.platform.forge.EventBuses
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.fml.DistExecutor
import net.minecraftforge.fml.common.Mod
import thedarkcolour.kotlinforforge.KotlinModLoadingContext

@Mod(DamageCrashForge.modId)
class DamageCrashForge {
    init {
        EventBuses.registerModEventBus(modId, KotlinModLoadingContext.get().getKEventBus())

        DamageCrashMod.init()

        DistExecutor.unsafeRunWhenOn(Dist.CLIENT) { Runnable { DamageCrashModClient.init() } }
        DistExecutor.unsafeRunWhenOn(Dist.DEDICATED_SERVER) { Runnable { DamageCrashModServer.init() } }
    }

    companion object {
        const val modId = "template"
    }
}