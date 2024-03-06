package com.example.school_inventoryapp.schoolinventoryapp.ui.screens.edituser.components

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.school_inventoryapp.schoolinventoryapp.ui.viewmodels.SignUpViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NameEditUser(
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
        value = userName,
        shape = RoundedCornerShape(10.dp),
        onValueChange = {
            singUpViewModel.onLoginChange(
                it,
                email,
                avatar,
                clase,
                curso,
                password1,
                password2,
            )
        },
        label = {
            Text(
                text = "Nombre y Apellidos", color = Color.Black,
                fontWeight = FontWeight.Bold
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Color.Black, containerColor = Color(0xFFF5F2F2),
            unfocusedBorderColor = Color.Transparent,
            focusedBorderColor = Color.Transparent
        ),
        leadingIcon = {
            Icon(
                imageVector = Icons.Rounded.Person,
                contentDescription = "name"
            )
        },
        modifier = Modifier.size(300.dp, 60.dp),
        singleLine = true
    )
}

