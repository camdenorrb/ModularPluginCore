package com.sxt.core.chat.base

import com.sxt.ext.add
import com.sxt.util.Gray
import com.sxt.util.Reset
import org.bukkit.event.player.AsyncPlayerChatEvent
import java.util.*

data class ChatPosition
constructor(val name: String, val output: (AsyncPlayerChatEvent) -> String, var modified: ((AsyncPlayerChatEvent) -> String)? = null) {

    private var position: Int = 0

    fun genOutput(event: AsyncPlayerChatEvent): String = "${modified?.invoke(event)?: output.invoke(event)}$Reset"


    companion object {

        val positions: LinkedList<ChatPosition> = LinkedList()

        val name = ChatPosition("Name"      , { "$Gray${it.player.name}" })
        val sep  = ChatPosition("Separator" , { " > " })
        val msg  = ChatPosition("Message"   , { it.message })


        init {
            positions.add(name, sep, msg)
            update()
        }


        fun addBefore(other: ChatPosition, chatPosition: ChatPosition) {
            positions.add(other.position, chatPosition)
            update()
        }

        fun addAfter(other: ChatPosition, chatPosition: ChatPosition) {
            positions.add(other.position + 1, chatPosition)
            update()
        }

        fun beginWith(chatPosition: ChatPosition) {
            positions.addFirst(chatPosition)
            update()
        }

        fun endWith(chatPosition: ChatPosition) {
            positions.addLast(chatPosition)
            update()
        }

        fun remove(chatPosition: ChatPosition) {
            positions.remove(chatPosition)
            update()
        }


        private fun update() {
            positions.forEachIndexed { index, position -> position.position = index }
        }
    }
}