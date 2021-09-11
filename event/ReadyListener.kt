package tech.osable.discord.event

import net.dv8tion.jda.api.events.GenericEvent
import net.dv8tion.jda.api.events.ReadyEvent
import net.dv8tion.jda.api.hooks.EventListener
import tech.osable.discord.getLogger

class ReadyListener : EventListener {

    override fun onEvent(event: GenericEvent) {
        if (event is ReadyEvent) {
            getLogger<ReadyListener>().info("Bot ready")
        }
    }

}