package com.example.school_inventoryapp.schoolinventoryapp.ui.screens.editmaterial.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.School
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.school_inventoryapp.schoolinventoryapp.ui.data.listaCursos
import com.example.school_inventoryapp.schoolinventoryapp.ui.viewmodels.MaterialsInfoViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CursoEditMaterial(
    nombreMaterial: String,
    cantidadMaterial: String,
    cursoMaterial: String,
    asignaturaMaterial: String,
    descriptionMaterial: String,
    imageMaterial: String,
    materialsInfoViewModel: MaterialsInfoViewModel
) {

    // Estado para controlar si el menú desplegable está expandido o no.
    var expanded by remember { mutableStateOf(false) }
    var enable by remember { mutableStateOf(false) }
    // Lista de cursos que hay en el centro educativo.
    val cursos = listaCursos()

    Column(verticalArrangement = Arrangement.SpaceBetween) {
        OutlinedTextField(
            value = cursoMaterial,
            shape = RoundedCornerShape(10.dp),
            enabled = enable,
            onValueChange = {
                materialsInfoViewModel.onCreateChange(
                    nombreMaterial,
                    cantidadMaterial,
                    it,
                    asignaturaMaterial,
                    descriptionMaterial,
                    imageMaterial
                )
            },
            label = {
                Text(
                    text = "Selecciona una curso",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Rounded.School,
                    contentDescription = "clase"
                )
            },
            readOnly = true,
            modifier = Modifier
                .size(300.dp, 60.dp)
                .clickable {
                    enable = false
                    expanded = true
                },
            singleLine = true,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                disabledTextColor = Color.Black,
                disabledBorderColor = Color.Transparent,
                disabledLeadingIconColor = MaterialTheme.colorScheme.outline,
                containerColor = Color(0xFFF5F2F2),
                unfocusedBorderColor = Color.Transparent,
                focusedBorderColor = Color.Transparent
            )
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .size(300.dp)
                .fillMaxHeight()
        ) {
            cursos.forEach { curso ->
                DropdownMenuItem(onClick = {
                    materialsInfoViewModel.onCreateChange(
                        nombreMaterial,
                        cantidadMaterial,
                        curso,
                        asignaturaMaterial,
                        descriptionMaterial,
                        imageMaterial
                    )
                    expanded = false
                }, text = {
                    Text(text = curso)
                }, colors = MenuDefaults.itemColors(textColor = Color.Black))

            }
        }
    }
}