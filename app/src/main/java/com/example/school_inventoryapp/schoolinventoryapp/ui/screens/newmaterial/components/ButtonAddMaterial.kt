package com.example.school_inventoryapp.schoolinventoryapp.ui.screens.newmaterial.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.school_inventoryapp.Routes
import com.example.school_inventoryapp.schoolinventoryapp.ui.viewmodels.MaterialsInfoViewModel

@Composable
fun ButtonAddMaterial(
    nombreMaterial: String,
    cantidadMaterial: String,
    cursoMaterial: String,
    asignaturaMaterial: String,
    descriptionMaterial: String,
    imageMaterial: String,
    materialsInfoViewModel: MaterialsInfoViewModel,
    navigationController: NavHostController
) {
    Button(
        onClick = {
            materialsInfoViewModel.addMaterial(
                nombreMaterial,
                cantidadMaterial,
                cursoMaterial,
                asignaturaMaterial,
                descriptionMaterial,
                imageMaterial
            ) { }
        },
        enabled = nombreMaterial.isNotEmpty() && cantidadMaterial.isNotEmpty() && asignaturaMaterial.isNotEmpty() && cursoMaterial.isNotEmpty() && descriptionMaterial.isNotEmpty(),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp)
            .height(50.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF3F51B5),
            disabledContainerColor = Color(0xFF03A9F4),
            contentColor = Color.White,
            disabledContentColor = Color.White
        ),
        shape = RoundedCornerShape(13.dp)

    )
    {
        Text(
            text = "Añadir",
            fontWeight = FontWeight.ExtraBold,
            color = Color.White,
            fontSize = 18.sp
        )
    }
}