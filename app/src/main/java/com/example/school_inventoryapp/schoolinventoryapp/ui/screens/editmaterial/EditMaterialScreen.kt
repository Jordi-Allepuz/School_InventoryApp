package com.example.school_inventoryapp.schoolinventoryapp.ui.screens.editmaterial

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavHostController
import com.example.school_inventoryapp.schoolinventoryapp.data.dataInfo.Material
import com.example.school_inventoryapp.schoolinventoryapp.ui.components.BottomBar
import com.example.school_inventoryapp.schoolinventoryapp.ui.screens.editmaterial.components.ContentEditMaterial
import com.example.school_inventoryapp.schoolinventoryapp.ui.viewmodels.LoginViewModel
import com.example.school_inventoryapp.schoolinventoryapp.ui.viewmodels.MaterialsInfoViewModel


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun EditMaterialScreen(
    materialsInfoViewModel: MaterialsInfoViewModel,
    loginViewModel: LoginViewModel,
    navController: NavHostController,
) {

    val material: Material? by materialsInfoViewModel.material.observeAsState()

    val cantidadMaterial: String by materialsInfoViewModel.cantidadMaterial.observeAsState(initial = material!!.cantidad)
    val asignaturaMaterial: String by materialsInfoViewModel.asignaturaMaterial.observeAsState(initial = material!!.asignatura)
    val cursoMaterial: String by materialsInfoViewModel.cursoMaterial.observeAsState(initial = material!!.curso)
    val descriptionMaterial: String by materialsInfoViewModel.descriptionMaterial.observeAsState(initial = material!!.description)
    val imageMaterial: String by materialsInfoViewModel.imageMaterial.observeAsState(initial = material!!.image)

    Scaffold(
        topBar = {/*empty*/ },
        content = { paddingValues ->
            ContentEditMaterial(
                material!!.nombre,
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
