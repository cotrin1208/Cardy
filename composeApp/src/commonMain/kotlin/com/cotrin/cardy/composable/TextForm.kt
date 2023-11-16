package com.cotrin.cardy.composable

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun TextForm(
	value: String = "",
	hintText: String = "",
	onChange: (String) -> Unit = {},
	trailingIcon: @Composable () -> Unit = {},
	visualTransformation: VisualTransformation = VisualTransformation.None
) {
	Card(
		shape = RoundedCornerShape(60.dp),
		modifier = Modifier.padding(10.dp)
	) {
		TextField(
			value = value,
			onValueChange = onChange,
			colors = TextFieldDefaults.colors(
				focusedContainerColor = Color.Transparent,
				unfocusedContainerColor = Color.Transparent,
				focusedIndicatorColor = Color.Transparent,
				unfocusedIndicatorColor = Color.Transparent
			),
			label = { Text(text = hintText) },
			modifier = Modifier.padding(10.dp, 5.dp).fillMaxWidth(),
			keyboardOptions = KeyboardOptions(
				keyboardType = KeyboardType.Password
			),
			trailingIcon = trailingIcon,
			visualTransformation = visualTransformation
		)
	}
}
