package com.example.school_inventoryapp.schoolinventoryapp.ui.screens.materialinfo.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.example.school_inventoryapp.Routes
import com.example.school_inventoryapp.schoolinventoryapp.data.dataInfo.Material
import com.example.school_inventoryapp.schoolinventoryapp.ui.components.EditButton
import com.example.school_inventoryapp.schoolinventoryapp.ui.components.ProgressIndicatorLogo
import com.example.school_inventoryapp.schoolinventoryapp.ui.viewmodels.MaterialsInfoViewModel

//@Composable
//fun MaterialInfoContent(
//    materialsInfoViewModel: MaterialsInfoViewModel,
//    navigationController: NavHostController,
//    paddingValues: PaddingValues
//) {
//    val brush =
//        Brush.linearGradient(listOf(MaterialTheme.colorScheme.background, Color(0xFFEBB25B)))
//
//    val material: Material? by materialsInfoViewModel.material.observeAsState()
//
//    if (material == null) {
//        Box(
//            modifier = Modifier
//                .fillMaxSize(), contentAlignment = Alignment.Center
//        ) {
//            ProgressIndicatorLogo()
//        }
//    } else {
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .verticalScroll(rememberScrollState())
//                .background(brush)
//                .padding(paddingValues)
//                .padding(top = 20.dp),
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            MaterialCard(material!!)
//            Spacer(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(60.dp)
//            )
//            MaterialInfo(material!!)
//            Spacer(modifier = Modifier
//                .fillMaxWidth()
//                .height(80.dp))
//            EditButton(navigationController)
//        }
//    }
//}

@Composable
fun MaterialInfoContent(
    materialsInfoViewModel: MaterialsInfoViewModel,
    navigationController: NavHostController,
    paddingValues: PaddingValues
) {
    val material: Material? by materialsInfoViewModel.material.observeAsState()

    if (material == null) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            ProgressIndicatorLogo() // Asegúrate de que este composable esté definido en alguna parte
        }
    } else {
        BoxWithConstraints(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Color.Transparent, MaterialTheme.colorScheme.background),
                        startY = 800f
                    )
                )
        ) {
            Image(
                painter = rememberImagePainter(data = material!!.image),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .verticalScroll(rememberScrollState())
                    .background(
                        Brush.verticalGradient(
                            listOf(Color.Transparent, MaterialTheme.colorScheme.surface),
                            startY = 100f,
                            endY = 1200f
                        )
                    )
                    .padding(paddingValues)
                    .padding(horizontal = 24.dp, vertical = 36.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                MaterialInfo(material!!)
                Spacer(Modifier.height(40.dp))
                EditButton("Edit Material") {navigationController.navigate(Routes.EditMaterialScreen.route)}
            }
        }
    }
}


