package com.sxt.core

import com.sxt.core.chat.PluginChatModule
import com.sxt.mod.SpigotPlugin

class PluginCore : SpigotPlugin() {


    private lateinit var chatModule: PluginChatModule


    override fun preEnable(): Boolean {
        coreInstance = this
        return super.preEnable()
    }

    override fun OnEnable() {
        chatModule = add(PluginChatModule())
    }

    companion object {

        lateinit var coreInstance: PluginCore

    }

}