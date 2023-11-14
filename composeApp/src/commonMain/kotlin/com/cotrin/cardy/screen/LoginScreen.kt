package com.cotrin.cardy.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen

class LoginScreen : Screen {
	@Composable
	override fun Content() {
		var email by remember { mutableStateOf("") }
		var password by remember { mutableStateOf("") }
		var passwordVisibility by remember { mutableStateOf(false) }

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
				Card(
					shape = RoundedCornerShape(60.dp),
					modifier = Modifier.padding(10.dp)
				) {
					TextField(
						value = email,
						onValueChange = { email = it },
						colors = TextFieldDefaults.colors(
							focusedContainerColor = Color.Transparent,
							unfocusedContainerColor = Color.Transparent,
							focusedIndicatorColor = Color.Transparent,
							unfocusedIndicatorColor = Color.Transparent
						),
						label = { Text(text = "email") },
						modifier = Modifier.padding(10.dp, 5.dp).fillMaxWidth()
					)
				}
				Card(
					shape = RoundedCornerShape(60.dp),
					modifier = Modifier.padding(10.dp)
				) {
					TextField(
						value = password,
						onValueChange = { password = it },
						colors = TextFieldDefaults.colors(
							focusedContainerColor = Color.Transparent,
							unfocusedContainerColor = Color.Transparent,
							focusedIndicatorColor = Color.Transparent,
							unfocusedIndicatorColor = Color.Transparent
						),
						label = { Text(text = "password") },
						modifier = Modifier.padding(10.dp, 5.dp).fillMaxWidth(),
						keyboardOptions = KeyboardOptions(
							keyboardType = KeyboardType.Password
						),
						trailingIcon = {
							IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
								val imageVector = if (passwordVisibility) Icons.Default.Close else Icons.Default.Edit
								Icon(imageVector, contentDescription = if (passwordVisibility) "Hide password" else "Show password")
							}
						},
						visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
					)
				}
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
