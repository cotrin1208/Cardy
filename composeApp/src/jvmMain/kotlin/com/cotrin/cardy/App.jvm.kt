package com.cotrin.cardy

import kotlinx.coroutines.CoroutineDispatcher
import org.jetbrains.skiko.MainUIDispatcher
import java.awt.Desktop
import java.net.URI

internal actual fun openUrl(url: String?) {
	val uri = url?.let { URI.create(it) } ?: return
	Desktop.getDesktop().browse(uri)
}

internal actual fun getDispatcher(): CoroutineDispatcher {
	return MainUIDispatcher
}
