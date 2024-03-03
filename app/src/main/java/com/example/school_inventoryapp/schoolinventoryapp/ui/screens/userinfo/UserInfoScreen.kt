package com.example.school_inventoryapp.schoolinventoryapp.ui.screens.userinfo

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.school_inventoryapp.schoolinventoryapp.data.dataInfo.User
import com.example.school_inventoryapp.schoolinventoryapp.ui.components.BottomBar
import com.example.school_inventoryapp.schoolinventoryapp.ui.components.ModalDrawer
import com.example.school_inventoryapp.schoolinventoryapp.ui.components.TopBar
import com.example.school_inventoryapp.schoolinventoryapp.ui.screens.userinfo.components.UserInfoContent
import com.example.school_inventoryapp.schoolinventoryapp.ui.viewmodels.LoginViewModel
import com.example.school_inventoryapp.schoolinventoryapp.ui.viewmodels.OpenAppsViewModel
import com.example.school_inventoryapp.schoolinventoryapp.ui.viewmodels.UserInfoViewModel


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun UserInfoScreen(
    userInfoViewModel: UserInfoViewModel,
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
                    "USER INFO",
                    estadoDrawer,
                    coroutina,
                    loginViewModel,
                    userInfoViewModel,
                    openAppsViewModel,
                    navigationController,
//                badgedOn = false
                )
            },
            content = { paddingValues ->
                UserInfoContent(
                    userInfoViewModel,
                    navigationController,
                    paddingValues
                )
            },
            bottomBar = { BottomBar(navigationController, loginViewModel) }
        )
    }
}




