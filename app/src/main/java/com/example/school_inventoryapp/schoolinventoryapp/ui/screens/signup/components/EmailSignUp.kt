package com.example.school_inventoryapp.schoolinventoryapp.ui.screens.signup.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.school_inventoryapp.schoolinventoryapp.ui.viewmodels.SignUpViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Email(
    userName: String,
    email: String,
    avatar: String,
    clase: String,
    curso: String,
    password1: String,
    password2: String,
    singUpViewModel: SignUpViewModel
) {
    OutlinedTextField(
        modifier = Modifier.size(300.dp, 60.dp),
        shape = RoundedCornerShape(10.dp),
        value = email,
        onValueChange = {
            singUpViewModel.onLoginChange(
                userName,
                it,
                avatar,
                clase,
                curso,
                password1,
                password2,
            )
        },
        label = {
            Text(
                text = "Correo electronico",
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Color.Black,
            containerColor = Color(0xFFF5F2F2),
            unfocusedBorderColor = Color.Transparent,
            focusedBorderColor = Color.Transparent
        ),
        leadingIcon = {
            Icon(
                imageVector = Icons.Rounded.Email,
                contentDescription = "email"
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine = true

    )
}