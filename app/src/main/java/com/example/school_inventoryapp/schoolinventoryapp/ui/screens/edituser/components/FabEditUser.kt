package com.example.school_inventoryapp.schoolinventoryapp.ui.screens.edituser.components

import android.widget.Toast
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.example.school_inventoryapp.Routes
import com.example.school_inventoryapp.schoolinventoryapp.ui.viewmodels.SignUpViewModel

@Composable
fun FabEditUser(
    navController: NavHostController,
    singUpViewModel: SignUpViewModel,
    userName: String,
    email: String,
    avatar: String,
    clase: String,
    centro: String,
    password1: String,
    isSignUpEnable: Boolean,
) {
    val contentToast = LocalContext.current.applicationContext
    FloatingActionButton(
        onClick = {
            if (isSignUpEnable) {
                Toast.makeText(
                    contentToast,
                    "REGISTRADO",
                    Toast.LENGTH_LONG
                ).show()
                singUpViewModel.registerUser(
                    userName,
                    email,
                    avatar,
                    clase,
                    centro
                )
                singUpViewModel.signUp(
                    email,
                    password1
                ) { navController.navigate(Routes.UserInfoScreen.route) }
            } else {
                Toast.makeText(
                    contentToast,
                    "REVISA LOS CAMPOS",
                    Toast.LENGTH_LONG
                ).show()
            }
        }, contentColor = Color.Black, containerColor = Color(0xFFe4bc7f)
    ) {
        Icon(imageVector = Icons.Rounded.Add, contentDescription = "check")
    }
}
