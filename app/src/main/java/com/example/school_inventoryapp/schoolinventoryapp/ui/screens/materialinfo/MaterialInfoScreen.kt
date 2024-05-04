package com.example.school_inventoryapp.schoolinventoryapp.ui.screens.materialinfo

import android.annotation.SuppressLint
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import com.example.school_inventoryapp.schoolinventoryapp.ui.components.BottomBar
import com.example.school_inventoryapp.schoolinventoryapp.ui.components.ModalDrawer
import com.example.school_inventoryapp.schoolinventoryapp.ui.components.TopBar
import com.example.school_inventoryapp.schoolinventoryapp.ui.screens.materialinfo.components.MaterialInfoContent
import com.example.school_inventoryapp.schoolinventoryapp.ui.screens.userinfo.components.UserInfoContent
import com.example.school_inventoryapp.schoolinventoryapp.ui.viewmodels.LoginViewModel
import com.example.school_inventoryapp.schoolinventoryapp.ui.viewmodels.MaterialsInfoViewModel
import com.example.school_inventoryapp.schoolinventoryapp.ui.viewmodels.OpenAppsViewModel
import com.example.school_inventoryapp.schoolinventoryapp.ui.viewmodels.UserInfoViewModel


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MaterialInfoScreen(
    userInfoViewModel: UserInfoViewModel,
    materialsInfoViewModel: MaterialsInfoViewModel,
    loginViewModel: LoginViewModel,
    openAppsViewModel: OpenAppsViewModel,
    navigationController: NavHostController
) {

    val coroutina = rememberCoroutineScope()
    val estadoDrawer = rememberDrawerState(initialValue = DrawerValue.Closed)

    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawer(
                estadoDrawer = estadoDrawer,
                coroutina = coroutina,
                userInfoViewModel,
                openAppsViewModel,
                navigationController
            )
        },
        gesturesEnabled = false,
        drawerState = estadoDrawer
    ) {
        Scaffold(
            topBar = {
                TopBar(
                    "MATERIAL INFO",
                    estadoDrawer,
                    coroutina,
                    loginViewModel,
                    userInfoViewModel,
                    openAppsViewModel,
                    navigationController,
                badgedOn = false
                )
            },
            content = { paddingValues ->
                MaterialInfoContent(
                    materialsInfoViewModel,
                    navigationController,
                    paddingValues
                )
            },
            bottomBar = { BottomBar(navigationController, loginViewModel) }
        )
    }
}




