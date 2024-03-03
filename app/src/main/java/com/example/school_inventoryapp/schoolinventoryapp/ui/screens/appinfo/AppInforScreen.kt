package com.example.school_inventoryapp.schoolinventoryapp.ui.screens.appinfo

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
import com.example.school_inventoryapp.schoolinventoryapp.ui.screens.appinfo.components.ContentAppInfoScreen
import com.example.school_inventoryapp.schoolinventoryapp.ui.viewmodels.LoginViewModel
import com.example.school_inventoryapp.schoolinventoryapp.ui.viewmodels.UserInfoViewModel


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InfoAppScreen(
    loginViewModel: LoginViewModel,
    userInfoViewModel: UserInfoViewModel,
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
                navigationController
            )
        },
        gesturesEnabled = false,
        drawerState = estadoDrawer
    ) {
        Scaffold(
            topBar = {
                TopBar(
                    "INFO APP",
                    estadoDrawer,
                    coroutina,
                    loginViewModel,
                    userInfoViewModel,
                    navigationController,
                    badgedOn = false,
                )
            },
            bottomBar = { BottomBar(navigationController, loginViewModel) },
            content = {
                ContentAppInfoScreen()
            })
    }
}



