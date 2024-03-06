package com.example.school_inventoryapp.schoolinventoryapp.ui.screens.creatematerial

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.school_inventoryapp.schoolinventoryapp.ui.components.BottomBar
import com.example.school_inventoryapp.schoolinventoryapp.ui.screens.creatematerial.components.ContentNewMaterial
import com.example.school_inventoryapp.schoolinventoryapp.ui.viewmodels.LoginViewModel


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NewMaterialScreen(
    loginViewModel: LoginViewModel,
    navController: NavHostController,
) {



    Scaffold(
        topBar = {/*empty*/ },
        content = { paddingValues ->
            ContentNewMaterial(
                paddingValues,
            )
        },
        bottomBar = { BottomBar(navController, loginViewModel ) },
    )
}
