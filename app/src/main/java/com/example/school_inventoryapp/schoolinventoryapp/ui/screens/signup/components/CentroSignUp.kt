package com.example.school_inventoryapp.schoolinventoryapp.ui.screens.signup.components

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Apartment
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
fun CentroSignUp(
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
        value = curso,
        onValueChange = {
            singUpViewModel.onLoginChange(
                userName,
                email,
                avatar,
                clase,
                it,
                password1,
                password2,
            )
        },
        label = { Text(text = "Centro de trabajo", color = Color.Black ,fontWeight = FontWeight.Bold) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Color.Black,
            containerColor = Color(0xFFF5F2F2),
            unfocusedBorderColor = Color.Transparent,
            focusedBorderColor = Color.Transparent
        ),
        leadingIcon = {
            Icon(
                imageVector = Icons.Rounded.Apartment,
                contentDescription = "centro"
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        modifier = Modifier.size(300.dp, 60.dp),
        shape = RoundedCornerShape(10.dp),
        singleLine = true

    )
}