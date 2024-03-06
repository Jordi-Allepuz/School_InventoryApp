package com.example.school_inventoryapp.schoolinventoryapp.ui.screens.newmaterial

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavHostController
import com.example.school_inventoryapp.schoolinventoryapp.ui.components.BottomBar
import com.example.school_inventoryapp.schoolinventoryapp.ui.screens.newmaterial.components.ContentNewMaterial
import com.example.school_inventoryapp.schoolinventoryapp.ui.viewmodels.LoginViewModel
import com.example.school_inventoryapp.schoolinventoryapp.ui.viewmodels.MaterialsInfoViewModel


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NewMaterialScreen(
    materialsInfoViewModel: MaterialsInfoViewModel,
    loginViewModel: LoginViewModel,
    navController: NavHostController,
) {

    val nombreMaterial: String by materialsInfoViewModel.nombreMaterial.observeAsState(initial = "")
    val cantidadMaterial: String by materialsInfoViewModel.cantidadMaterial.observeAsState(initial = "")
    val asignaturaMaterial: String by materialsInfoViewModel.asignaturaMaterial.observeAsState(initial = "")
    val cursoMaterial: String by materialsInfoViewModel.cursoMaterial.observeAsState(initial = "")
    val descriptionMaterial: String by materialsInfoViewModel.descriptionMaterial.observeAsState(initial = "")
    val imageMaterial: String by materialsInfoViewModel.imageMaterial.observeAsState(initial = "")



    Scaffold(
        topBar = {/*empty*/ },
        content = { paddingValues ->
            ContentNewMaterial(
                nombreMaterial,
                cantidadMaterial,
                cursoMaterial,
                asignaturaMaterial,
                descriptionMaterial,
                imageMaterial,
                materialsInfoViewModel,
                navController,
                paddingValues,
            )
        },
        bottomBar = { BottomBar(navController, loginViewModel) },
    )
}
