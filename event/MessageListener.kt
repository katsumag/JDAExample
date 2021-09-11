package tech.osable.discord.event

import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import tech.osable.discord.WordFilter
import tech.osable.discord.getLogger

class MessageListener : ListenerAdapter() {

    private val logger = getLogger<MessageListener>()

    override fun onMessageReceived(event: MessageReceivedEvent) {

        val msg = event.message.contentRaw

        if (WordFilter.scan(msg)) {
            event.message.delete().queue()
            logger.info("Message deleted from ${event.message.author}: \n$msg")
        }

    }

}