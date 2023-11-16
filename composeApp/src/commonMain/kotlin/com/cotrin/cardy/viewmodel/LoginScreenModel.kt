package com.cotrin.cardy.viewmodel

import cafe.adriel.voyager.core.model.ScreenModel
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.AuthResult
import dev.gitlive.firebase.auth.auth
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class LoginScreenModel : ScreenModel {
	private val _email = MutableStateFlow("")
	val email = _email.asStateFlow()

	private val _password = MutableStateFlow("")
	val password = _password.asStateFlow()

	private val _passwordVisibility = MutableStateFlow(true)
	val passwordVisibility = _passwordVisibility.asStateFlow()

	suspend fun login(): AuthResult {
		return Firebase.auth.signInWithEmailAndPassword(_email.value, _password.value)
	}

	fun setEmail(value: String) {
		_email.value = value
	}
}
