package tech.osable.discord

import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.entities.Activity
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import tech.osable.discord.event.MessageListener
import tech.osable.discord.event.ReadyListener

class BotEntryPoint(private val token: String) {

    fun init() {

        val jda = JDABuilder
            .createDefault(token)
            .setActivity(Activity.watching("Your Language"))
            .addEventListeners(
                ReadyListener(),
                MessageListener()
            )
            .build()

        jda.awaitReady()

    }

}

inline fun <reified T> getLogger(): Logger = LoggerFactory.getLogger(T::class.java)