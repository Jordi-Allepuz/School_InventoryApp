package com.example.school_inventoryapp.schoolinventoryapp.ui.screens.signup.components

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.school_inventoryapp.schoolinventoryapp.ui.viewmodels.SignUpViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Password1(
    userName: String,
    email: String,
    avatar: String,
    clase: String,
    curso: String,
    password1: String,
    password2: String,
    singUpViewModel: SignUpViewModel,
    passwordVisibility: Boolean,
    setPasswordVisibility: (Boolean) -> Unit
) {
    OutlinedTextField(
        value = password1,
        onValueChange = {
            singUpViewModel.onLoginChange(
                userName,
                email,
                avatar,
                clase,
                curso,
                it,
                password2
            )
        },
        label = { Text(text = "Contraseña", color = Color.Black,fontWeight = FontWeight.Bold) },
        trailingIcon = {
            val passwordImagen = if (passwordVisibility) {
                Icons.Filled.VisibilityOff
            } else {
                Icons.Filled.Visibility
            }
            IconButton(onClick = { setPasswordVisibility(!passwordVisibility) }) {
                Icon(
                    imageVector = passwordImagen,
                    contentDescription = "visibility"
                )

            }
        },
        modifier = Modifier.size(300.dp, 90.dp),
        shape = RoundedCornerShape(10.dp),
        visualTransformation = if (passwordVisibility) {
            PasswordVisualTransformation()
        } else {
            VisualTransformation.None
        },
        supportingText = { Text(text = "Introduce contraseña", color = Color.Black,fontWeight = FontWeight.Bold) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Color.Black,
            containerColor = Color(0xFFF5F2F2),
            unfocusedBorderColor = Color.Transparent,
            focusedBorderColor = Color.Transparent
        ),
        singleLine = true
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Password2(
    userName: String,
    email: String,
    avatar: String,
    clase: String,
    curso: String,
    password1: String,
    password2: String,
    singUpViewModel: SignUpViewModel,
    passwordVisibility: Boolean,
    setPasswordVisibility: (Boolean) -> Unit
) {
    OutlinedTextField(
        value = password2,
        onValueChange = {
            singUpViewModel.onLoginChange(
                userName,
                email,
                avatar,
                clase,
                curso,
                password1,
                it
            )
        },
        label = { Text(text = "Contraseña", color = Color.Black,fontWeight = FontWeight.Bold) },
        trailingIcon = {
            val passwordImagen = if (passwordVisibility) {
                Icons.Filled.VisibilityOff
            } else {
                Icons.Filled.Visibility
            }
            IconButton(onClick = { setPasswordVisibility(!passwordVisibility) }) {
                Icon(
                    imageVector = passwordImagen,
                    contentDescription = "visibility"
                )

            }
        },
        modifier = Modifier.size(300.dp, 90.dp),
        shape = RoundedCornerShape(10.dp),
        visualTransformation = if (passwordVisibility) {
            PasswordVisualTransformation()
        } else {
            VisualTransformation.None
        },
        supportingText = { Text(text = "Confirmar contraseña", color = Color.Black,fontWeight = FontWeight.Bold) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Color.Black,
            containerColor = Color(0xFFF5F2F2),
            unfocusedBorderColor = Color.Transparent,
            focusedBorderColor = Color.Transparent
        ),
        singleLine = true
    )
}



