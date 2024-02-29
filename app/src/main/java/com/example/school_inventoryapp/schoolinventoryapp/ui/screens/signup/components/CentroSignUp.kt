package com.example.school_inventoryapp.schoolinventoryapp.ui.screens.signup.components

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Apartment
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.School
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
fun Centro(
    userName: String,
    age: String,
    email: String,
    favoriteGenere: String,
    password1: String,
    password2: String,
    singUpViewModel: SignUpViewModel
) {
    OutlinedTextField(
        value = email,
        onValueChange = {
            singUpViewModel.onLoginChange(
                it,
                userName,
                password1,
                password2,
                age,
                favoriteGenere
            )
        },
        label = { Text(text = "Centro Educativo", color = Color.Black) },
        colors = TextFieldDefaults.outlinedTextFieldColors(textColor = Color.Black),
        leadingIcon = {
            Icon(
                imageVector = Icons.Rounded.Apartment,
                contentDescription = "centro"
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        modifier = Modifier.size(300.dp, 60.dp),
        singleLine = true

    )
}