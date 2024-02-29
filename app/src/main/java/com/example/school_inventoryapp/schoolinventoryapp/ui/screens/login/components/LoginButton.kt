package com.example.school_inventoryapp.schoolinventoryapp.ui.screens.login.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.school_inventoryapp.Routes
import com.example.school_inventoryapp.schoolinventoryapp.ui.viewmodels.LoginViewModel

@Composable
fun LoginButton(
    loginEnable: Boolean,
    loginViewModel: LoginViewModel,
    navigationController: NavHostController,
    email: String,
    password: String
) {

    Button(
        onClick = {
            loginViewModel.login(
                email, password
            ) {
                navigationController.navigate(Routes.UserInfoScreen.route)
            }
        },
        enabled = loginEnable,
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFe4bc7f),
            disabledContainerColor = Color(0xFFEBD8BC),
            contentColor = Color.White,
            disabledContentColor = Color.White
        )
    )
    {
        Text(text = "Log in")
    }
}
