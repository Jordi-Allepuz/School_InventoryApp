package com.example.school_inventoryapp.schoolinventoryapp.ui.screens.editmaterial.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.school_inventoryapp.schoolinventoryapp.ui.components.ProgressIndicatorLogo
import com.example.school_inventoryapp.schoolinventoryapp.ui.viewmodels.MaterialsInfoViewModel


@Composable
fun ContentEditMaterial(
    nombreMaterial: String,
    cantidadMaterial: String,
    cursoMaterial: String,
    asignaturaMaterial: String,
    descriptionMaterial: String,
    imageMaterial: String,
    materialsInfoViewModel: MaterialsInfoViewModel,
    navigationController: NavHostController,
    paddingValues: PaddingValues,
) {

    val isLoading: Boolean by materialsInfoViewModel.isLoading.observeAsState(false)


    if (isLoading) {
        Box(
            modifier = Modifier
                .fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            ProgressIndicatorLogo()
        }
    } else {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(paddingValues)
        ) {

            Column(
                verticalArrangement = Arrangement.spacedBy(20.dp),
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(bottom = 80.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                NameNewMaterial(
                    nombreMaterial,
                    cantidadMaterial,
                    cursoMaterial,
                    asignaturaMaterial,
                    descriptionMaterial,
                    imageMaterial,
                    materialsInfoViewModel
                )
                CantidadEditMaterial(
                    nombreMaterial,
                    cantidadMaterial,
                    cursoMaterial,
                    asignaturaMaterial,
                    descriptionMaterial,
                    imageMaterial,
                    materialsInfoViewModel
                )
                CursoEditMaterial(
                    nombreMaterial,
                    cantidadMaterial,
                    cursoMaterial,
                    asignaturaMaterial,
                    descriptionMaterial,
                    imageMaterial,
                    materialsInfoViewModel
                )
                AsignaturaEditMaterial(
                    nombreMaterial,
                    cantidadMaterial,
                    cursoMaterial,
                    asignaturaMaterial,
                    descriptionMaterial,
                    imageMaterial,
                    materialsInfoViewModel
                )
                DescripcionEditMaterial(
                    nombreMaterial,
                    cantidadMaterial,
                    cursoMaterial,
                    asignaturaMaterial,
                    descriptionMaterial,
                    imageMaterial,
                    materialsInfoViewModel
                )
//                ImageNewMaterial(
//                    nombreMaterial,
//                    cantidadMaterial,
//                    cursoMaterial,
//                    asignaturaMaterial,
//                    descriptionMaterial,
//                    imageMaterial,
//                    materialsInfoViewModel
//                )
                ButtonEditMaterial(
                    nombreMaterial,
                    cantidadMaterial,
                    cursoMaterial,
                    asignaturaMaterial,
                    descriptionMaterial,
                    imageMaterial,
                    materialsInfoViewModel,
                    navigationController
                )
            }
        }
    }
}





