package com.example.school_inventoryapp.schoolinventoryapp.ui.screens.materialslist.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.material3.ChipBorder
import androidx.compose.material3.DropdownMenu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.school_inventoryapp.R
import com.example.school_inventoryapp.schoolinventoryapp.data.dataInfo.Material
import com.example.school_inventoryapp.schoolinventoryapp.ui.components.ProgressIndicatorLogo
import com.example.school_inventoryapp.schoolinventoryapp.ui.viewmodels.MaterialsInfoViewModel
import com.example.school_inventoryapp.schoolinventoryapp.ui.viewmodels.UserInfoViewModel


@Composable
fun ContentMaterialList(
    userInfoViewModel: UserInfoViewModel,
    materialsInfoViewModel: MaterialsInfoViewModel,
    navigationController: NavHostController,
    paddingValues: PaddingValues
) {

    val materials: List<Material>? by materialsInfoViewModel.materialList.observeAsState()
    var selectedChip by remember { mutableStateOf<String?>(null) }

    val lazyGridState = rememberLazyGridState()

    LaunchedEffect(Unit) {
        materialsInfoViewModel.getMaterialList()
    }

    LaunchedEffect(selectedChip) {
        if (selectedChip == null) {
            materialsInfoViewModel.getMaterialList()  // Carga todos los materiales si no hay selección
        } else {
            materialsInfoViewModel.getMaterialsBySubject(selectedChip!!)  // Carga materiales por asignatura
        }
    }

    if (materials == null) {
        Box(
            modifier = Modifier
                .fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            ProgressIndicatorLogo()
        }
    } else {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row(modifier = Modifier.padding(8.dp)) {
                // Lista de asignaturas
                val subjects = listOf("Ciéncias", "Matemátiques", "Llengües")
                subjects.forEach { subject ->
                    Chip(
                        title = subject,
                        isSelected = selectedChip == subject
                    ) {
                        if (selectedChip == subject) {
                            selectedChip = null  // Deseleccionar si el mismo chip es clicado de nuevo
                        } else {
                            selectedChip = subject  // Seleccionar nuevo chip
                        }
                    }
                }
            }
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                state = lazyGridState,
                content = {
                    items(materials!!) { material ->
                        MaterialListCard(material, materialsInfoViewModel, navigationController)
                    }
                },
                verticalArrangement = Arrangement.Center
            )
        }
    }
}

