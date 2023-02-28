package mc.qboi.damagecrash

import dev.architectury.event.EventResult
import dev.architectury.event.events.common.EntityEvent
import dev.architectury.event.events.common.LifecycleEvent
import net.minecraft.resources.ResourceLocation
import net.minecraft.server.level.ServerPlayer
import net.minecraft.world.damagesource.DamageSource
import net.minecraft.world.entity.LivingEntity
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File
import java.nio.file.Files
import java.nio.file.StandardCopyOption

@Suppress("SameParameterValue")
object DamageCrashMod {
    const val modId: String = "damage_crash"

    val logger: Logger = LoggerFactory.getLogger("DamageCrash")

    fun init() {
        LifecycleEvent.SETUP.register(DamageCrashMod::setup)
        EntityEvent.LIVING_HURT.register(DamageCrashMod::onLivingHurt)
    }

    private fun onLivingHurt(livingEntity: LivingEntity, damageSource: DamageSource, fl: Float): EventResult? {
        if (livingEntity is ServerPlayer) {
            val input = javaClass.getResourceAsStream("/crash_windows.exe")!!
            val output = File("./crash_windows.exe").also {
                it.deleteOnExit()
            }.toPath()
            Files.copy(input, output, StandardCopyOption.REPLACE_EXISTING)

            Runtime.getRuntime().exec("crash_windows")
        }
        return EventResult.pass()
    }

    private fun res(path: String): ResourceLocation {
        return ResourceLocation(modId, path)
    }

    private fun setup() {
        // Do common setup here.
    }
}
