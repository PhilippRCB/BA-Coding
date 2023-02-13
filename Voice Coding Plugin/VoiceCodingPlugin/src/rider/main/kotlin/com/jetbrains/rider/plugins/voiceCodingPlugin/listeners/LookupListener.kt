package com.jetbrains.rider.plugins.voiceCodingPlugin.listeners

import com.intellij.codeInsight.lookup.Lookup
import com.intellij.codeInsight.lookup.LookupEvent
import com.intellij.codeInsight.lookup.LookupListener
import com.jetbrains.rider.plugins.voiceCodingPlugin.Logger
import com.jetbrains.rider.plugins.voiceCodingPlugin.SpeechHandler

class LookupListener: LookupListener {
    private lateinit var _lookup: Lookup
    private var currentCount = 0

    override fun lookupShown(event: LookupEvent) {
        _lookup = event.lookup
    }

    override fun uiRefreshed() {
        val newCount = _lookup.items.size
        if (newCount != currentCount) currentCount = newCount
        else if (currentCount != 0) {
            Logger.write("Loaded autocomplete options, $currentCount found")
            SpeechHandler.insertDictation(_lookup.items, false)
        }
    }
}