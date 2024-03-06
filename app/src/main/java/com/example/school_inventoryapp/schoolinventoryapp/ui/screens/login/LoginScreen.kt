package com.example.school_inventoryapp.schoolinventoryapp.ui.screens.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.school_inventoryapp.schoolinventoryapp.ui.components.ProgressIndicatorLogo
import com.example.school_inventoryapp.schoolinventoryapp.ui.screens.login.components.Body
import com.example.school_inventoryapp.schoolinventoryapp.ui.viewmodels.LoginViewModel
import com.example.school_inventoryapp.schoolinventoryapp.ui.viewmodels.SignUpViewModel

@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel,
    navigationController: NavHostController
) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(8.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val isLoading: Boolean by loginViewModel.isLoading.observeAsState(false)
        if (isLoading) {
            Box(
                modifier = Modifier
                    .fillMaxSize(), contentAlignment = Alignment.Center
            ) {
                ProgressIndicatorLogo()
            }
        } else {
            Body(
                loginViewModel,
                navigationController
            )
        }
    }
}




























