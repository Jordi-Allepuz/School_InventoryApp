package com.example.school_inventoryapp.schoolinventoryapp.ui.screens.signup.components

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.school_inventoryapp.schoolinventoryapp.ui.viewmodels.SignUpViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Email(
    userName: String,
    email: String,
    clase:String,
    curso:String,
    password1: String,
    password2: String,
    singUpViewModel: SignUpViewModel
) {
    OutlinedTextField(
        value = email,
        onValueChange = {
            singUpViewModel.onLoginChange(
                userName,
                it,
                clase,
                curso,
                password1,
                password2,
            )
        },
        label = { Text(text = "Correo electronico", color = Color.Black) },
        colors = TextFieldDefaults.outlinedTextFieldColors(textColor = Color.Black),
        leadingIcon = {
            Icon(
                imageVector = Icons.Rounded.Email,
                contentDescription = "email"
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        modifier = Modifier.size(300.dp, 60.dp),
        singleLine = true

    )
}