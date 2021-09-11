package tech.osable.discord

import tech.osable.discord.model.WordListEntry
import tech.osable.exposed.delete
import tech.osable.exposed.getAll
import tech.osable.exposed.insert
import tech.osable.exposed.tables.WordListTable

object WordFilter {

    private val wordList = WordListTable.getAll()

    fun addToWordlist(entry: WordListEntry) {

        wordList.add(entry)
        WordListTable.insert(entry)

    }

    fun removeFromWordlist(word: String) {

        val entry = wordList.first { it.word == word }
        wordList.remove(entry)
        WordListTable.delete(entry)

    }

    fun scan(message: String): Boolean {

        wordList.forEach {
            if (message.contains(it.word)) {
                return true
            }
        }

        return false

    }

}