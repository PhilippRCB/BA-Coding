package com.jetbrains.rider.plugins.voiceCodingPlugin.userActions

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.jetbrains.rider.plugins.voiceCodingPlugin.VoiceController

class ToggleVerbatimModeAction: AnAction() {
    override fun actionPerformed(p0: AnActionEvent) {
        VoiceController.toggleVerbatimMode()
    }
}