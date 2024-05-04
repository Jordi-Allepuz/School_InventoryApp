package com.example.school_inventoryapp.schoolinventoryapp.ui.screens.materialslist.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.school_inventoryapp.Routes
import com.example.school_inventoryapp.schoolinventoryapp.data.dataInfo.Material
import com.example.school_inventoryapp.schoolinventoryapp.ui.viewmodels.MaterialsInfoViewModel
import com.example.school_inventoryapp.schoolinventoryapp.ui.viewmodels.UserInfoViewModel


@OptIn(ExperimentalCoilApi::class)
@Composable
fun MaterialListCard(
    material: Material,
    materialsInfoViewModel: MaterialsInfoViewModel,
    navigationController: NavHostController,
) {
    Card(
        modifier = Modifier
            .width(300.dp)
            .height(250.dp)
            .padding(vertical = 16.dp, horizontal = 20.dp)
            .clickable {
                materialsInfoViewModel.getMaterialInfo(material.nombre)
                navigationController.navigate(Routes.MaterialInfoScreen.route)
            },
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF358F80))
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = material.nombre,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            Image(
                painter = rememberImagePainter(data = material.image),
                contentDescription = null,
                modifier = Modifier
                    .width(150.dp)
                    .height(170.dp),
                contentScale = ContentScale.Crop,
            )
        }

    }
}
