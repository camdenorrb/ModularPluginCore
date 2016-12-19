package com.sxt.core.chat

import com.sxt.core.PluginCore
import com.sxt.core.chat.base.ChatPosition
import com.sxt.mod.SpigotPluginModule
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.player.AsyncPlayerChatEvent

class PluginChatModule : SpigotPluginModule("Chat", PluginCore.coreInstance) {
    
    @EventHandler(ignoreCancelled = true, priority = EventPriority.HIGHEST)
    fun onAsyncChat(event: AsyncPlayerChatEvent) {
        event.isCancelled = true

        val builder = StringBuilder()
        ChatPosition.positions.forEach { builder.append(it.genOutput(event)) }

        spigotPlugin.server.broadcastMessage(builder.toString())
    }

}
