package com.cotrin.cardy

import android.app.Application
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class AndroidApp : Application() {
	companion object {
		lateinit var INSTANCE: AndroidApp
	}

	override fun onCreate() {
		super.onCreate()
		INSTANCE = this
	}
}

class AppActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			Test()
		}
	}
}

internal actual fun openUrl(url: String?) {
	val uri = url?.let { Uri.parse(it) } ?: return
	val intent = Intent().apply {
		action = Intent.ACTION_VIEW
		data = uri
		addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
	}
	AndroidApp.INSTANCE.startActivity(intent)
}

internal actual fun getDispatcher(): CoroutineDispatcher {
	return Dispatchers.Main
}
