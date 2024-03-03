package com.example.school_inventoryapp.schoolinventoryapp.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.school_inventoryapp.schoolinventoryapp.ui.viewmodels.LoginViewModel
import com.example.school_inventoryapp.schoolinventoryapp.ui.viewmodels.UserInfoViewModel
import com.example.school_inventoryapp.schoolinventoryapp.ui.viewmodels.OpenAppsViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    titulo: String,
    estadoDrawer: DrawerState,
    coroutina: CoroutineScope,// Scope de corutina para ejecutar acciones asíncronas.
    loginViewModel: LoginViewModel,
    userInfoViewModel: UserInfoViewModel,
    openAppsViewModel: OpenAppsViewModel,
    navigationController: NavHostController,
    badgedOn: Boolean
) {
// Estado para controlar la visibilidad del menú desplegable.
    var menuOpen by rememberSaveable { mutableStateOf(false) }

    TopAppBar(
        title = { Text(text = titulo, color = Color.Black) },
        navigationIcon = {
            // Ícono para abrir o cerrar el drawer lateral.
            IconButton(onClick = {
                coroutina.launch {
                    if (estadoDrawer.isClosed) {
                        estadoDrawer.open()
                    } else {
                        estadoDrawer.close()
                    }
                }
            }) {
                Icon(imageVector = Icons.Rounded.Menu, contentDescription = "menu")
            }
        },
        actions = {
            // Muestra un ícono con insignia si `badgedOn` es verdadero.
            if (badgedOn) BadgedBox()
            IconButton(onClick = { openAppsViewModel.visitShop("https://www.abacus.coop/es/home") }) {
                Icon(imageVector = Icons.Rounded.ShoppingCart, contentDescription = "search")
            }
            // Ícono para abrir el menú desplegable.
            IconButton(onClick = { menuOpen = true }) {
                Icon(imageVector = Icons.Filled.MoreVert, contentDescription = "overflow")
                OverFlowMenu(
                    expanded = menuOpen,
                    onDismiss = { menuOpen = !menuOpen }, loginViewModel, navigationController
                )

            }
        },
        colors = TopAppBarDefaults.largeTopAppBarColors(
            actionIconContentColor = Color.Black,
            navigationIconContentColor = Color.Black
        )
    )
}