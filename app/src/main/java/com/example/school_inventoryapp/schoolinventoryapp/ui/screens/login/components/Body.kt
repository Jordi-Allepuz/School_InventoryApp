package com.example.school_inventoryapp.schoolinventoryapp.ui.screens.login.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.school_inventoryapp.schoolinventoryapp.ui.viewmodels.LoginViewModel

/*BODY*/
@Composable
fun Body(
    loginViewModel: LoginViewModel,
    navigationController: NavHostController
) {
    val email: String by loginViewModel.email.observeAsState(initial = "")
    val password: String by loginViewModel.password.observeAsState(initial = "")
    val isLoginEnable: Boolean by loginViewModel.isLoginEnable.observeAsState(initial = false)

    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())) {
        Header()
        Spacer(modifier = Modifier.size(100.dp))
        ImageLogo(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.size(50.dp))
        Email(email) {
            loginViewModel.onLoginChange(email = it, password = password)
        }
        Spacer(modifier = Modifier.size(10.dp))
        Password(password) {
            loginViewModel.onLoginChange(email = email, password = it)
        }
        Spacer(modifier = Modifier.size(8.dp))
        Text(modifier = Modifier.fillMaxWidth(),
            text = "¿Olvidaste contraseña?",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            textAlign = TextAlign.End
        )
        Spacer(modifier = Modifier.size(30.dp))
        LoginButton(
            isLoginEnable,
            loginViewModel,
            navigationController,
            email,
            password
        )
        Spacer(modifier = Modifier.size(20.dp))
        LoginDivider()
        Spacer(modifier = Modifier.size(20.dp))
        SignUpBottom(navigationController)
    }
}


