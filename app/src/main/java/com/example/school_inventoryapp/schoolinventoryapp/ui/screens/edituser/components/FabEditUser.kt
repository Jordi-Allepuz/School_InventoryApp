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
import com.example.school_inventoryapp.schoolinventoryapp.data.dataInfo.User
import com.example.school_inventoryapp.schoolinventoryapp.ui.viewmodels.SignUpViewModel
import kotlin.math.sin

@Composable
fun FabEditUser(
    navController: NavHostController,
    singUpViewModel: SignUpViewModel,
    userName: String,
    email: String,
    avatar: String,
    clase: String,
    centro: String
) {
    val contentToast = LocalContext.current.applicationContext
    FloatingActionButton(
        onClick = {
            Toast.makeText(
                contentToast,
                "EDITADO CORRECTAMENTE",
                Toast.LENGTH_LONG
            ).show()
            singUpViewModel.updateUser(
                userName,
                email,
                avatar,
                clase,
                centro
            ) {
                navController.navigate(Routes.UserInfoScreen.route)
            }
        }, contentColor = Color.Black, containerColor = Color(0xFFe4bc7f)
    ) {
        Icon(imageVector = Icons.Rounded.Add, contentDescription = "check")
    }
}
