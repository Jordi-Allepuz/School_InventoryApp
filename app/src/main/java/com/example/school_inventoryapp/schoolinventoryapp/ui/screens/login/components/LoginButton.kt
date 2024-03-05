package com.example.school_inventoryapp.schoolinventoryapp.ui.screens.login.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
        modifier = Modifier.fillMaxWidth().padding(horizontal= 15.dp).height(50.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF3F51B5),
            disabledContainerColor = Color(0xFF03A9F4),
            contentColor = Color.White,
            disabledContentColor = Color.White
        ),
        shape= RoundedCornerShape(13.dp)

    )
    {
        Text(text = "Log in", fontWeight = FontWeight.ExtraBold, color = Color.White, fontSize = 18.sp)
    }
}
