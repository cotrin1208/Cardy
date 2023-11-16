package com.cotrin.cardy.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import com.cotrin.cardy.composable.TextForm
import com.cotrin.cardy.viewmodel.LoginScreenModel
import compose.icons.FeatherIcons
import compose.icons.feathericons.Eye
import compose.icons.feathericons.EyeOff
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

class LoginScreen(private val dispatcher: CoroutineDispatcher) : Screen {
	@Composable
	override fun Content() {
		var password by remember { mutableStateOf("") }
		var passwordVisibility by remember { mutableStateOf(false) }
		val viewModel = rememberScreenModel { LoginScreenModel() }
		val email by viewModel.email.collectAsState()
		val scope = rememberCoroutineScope()

		Row(
			horizontalArrangement = Arrangement.Center,
			verticalAlignment = Alignment.CenterVertically
		) {
			Spacer(Modifier.weight(1f))
			Column(
				horizontalAlignment = Alignment.CenterHorizontally,
				verticalArrangement = Arrangement.Center,
				modifier = Modifier.weight(3f)
			) {
				TextForm(
					value = email,
					onChange = {
						scope.launch(dispatcher) {
							viewModel.setEmail(it)
							password = it
						}
					},
					hintText = "メールアドレス"
				)
				TextForm(
					value = password,
					onChange = { password = it },
					hintText = "パスワード",
					trailingIcon = {
						IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
							val imageVector = if (passwordVisibility) FeatherIcons.Eye else FeatherIcons.EyeOff
							Icon(
								imageVector,
								contentDescription = if (passwordVisibility) "Hide password" else "Show password"
							)
						}
					},
					visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation()
				)
				Card(
					shape = RoundedCornerShape(60.dp),
					modifier = Modifier.padding(10.dp)
				) {

				}
			}
			Spacer(Modifier.weight(1f))
		}
	}
}
