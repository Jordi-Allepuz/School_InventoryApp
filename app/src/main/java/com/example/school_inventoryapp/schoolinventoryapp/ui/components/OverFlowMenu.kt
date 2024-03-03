package com.example.school_inventoryapp.schoolinventoryapp.ui.components

import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.school_inventoryapp.Routes
import com.example.school_inventoryapp.schoolinventoryapp.ui.viewmodels.LoginViewModel

// Define un composable para representar un menú desplegable.
@Composable
fun OverFlowMenu(
    expanded: Boolean,
    onDismiss: () -> Unit,
    loginViewModel: LoginViewModel,
    navigationController: NavHostController
) {


    DropdownMenu(
        expanded = expanded,// Controla la visibilidad del menú
        onDismissRequest = onDismiss
    ) {
        DropdownMenuItem(onClick = {
            // Llama a la función 'logOut' del ViewModel para cerrar sesión.
            loginViewModel.logOut {
                // Navega hacia la pantalla de inicio de sesión después de cerrar sesión.
                navigationController.navigate(Routes.LoginScreen.route)
            }
        },
            text = { Text(text = "LOG OUT", color = Color.White) }
        )
    }
}


