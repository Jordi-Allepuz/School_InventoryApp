package com.example.school_inventoryapp.schoolinventoryapp.ui.screens.newmaterial.components

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.school_inventoryapp.schoolinventoryapp.ui.viewmodels.MaterialsInfoViewModel
import com.example.school_inventoryapp.schoolinventoryapp.ui.viewmodels.SignUpViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NameNewMaterial(
    nombreMaterial: String,
    cantidadMaterial: String,
    cursoMaterial: String,
    asignaturaMaterial: String,
    descriptionMaterial: String,
    imageMaterial: String,
    materialsInfoViewModel: MaterialsInfoViewModel

) {
    OutlinedTextField(
        value = nombreMaterial,
        shape = RoundedCornerShape(10.dp),
        onValueChange = {
            materialsInfoViewModel.onCreateChange(
                it,
                cantidadMaterial,
                cursoMaterial,
                asignaturaMaterial,
                descriptionMaterial,
                imageMaterial
            )
        },
        label = {
            Text(
                text = "Nombre Material", color = Color.Black,
                fontWeight = FontWeight.Bold
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Color.Black, containerColor = Color(0xFFF5F2F2),
            unfocusedBorderColor = Color.Transparent,
            focusedBorderColor = Color.Transparent
        ),
        leadingIcon = {
            Icon(
                imageVector = Icons.Rounded.Person,
                contentDescription = "name"
            )
        },
        modifier = Modifier.size(300.dp, 60.dp),
        singleLine = true
    )
}

