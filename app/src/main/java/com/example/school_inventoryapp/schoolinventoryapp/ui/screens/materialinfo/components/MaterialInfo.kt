package com.example.school_inventoryapp.schoolinventoryapp.ui.screens.materialinfo.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Apartment
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.School
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.school_inventoryapp.schoolinventoryapp.data.dataInfo.Material
import com.example.school_inventoryapp.schoolinventoryapp.data.dataInfo.User

//@Composable
//fun MaterialInfo(material: Material) {
//    Column(modifier = Modifier
//        .fillMaxWidth()
//        .padding(start = 40.dp), verticalArrangement= Arrangement.spacedBy(25.dp)) {
//        Row(modifier = Modifier.fillMaxWidth()) {
//            Column(modifier = Modifier
//                .fillMaxWidth()
//                .padding(start = 20.dp)) {
//                Text(text = "Temática")
//                Text(text = material.asignatura, fontSize = 20.sp, fontWeight = FontWeight.Bold)
//            }
//        }
//        Row(modifier = Modifier.fillMaxWidth()) {
//            Column(modifier = Modifier
//                .fillMaxWidth()
//                .padding(start = 20.dp)) {
//                Text(text = "Curso")
//                Text(text = material.curso, fontSize = 20.sp, fontWeight = FontWeight.Bold)
//            }
//
//        }
//        Row(modifier = Modifier.fillMaxWidth()) {
//            Column(modifier = Modifier
//                .fillMaxWidth()
//                .padding(start = 20.dp)) {
//                Text(text = "Cantidad")
//                Text(text = "${material.cantidad} unidades", fontSize = 20.sp, fontWeight = FontWeight.Bold)
//            }
//        }
//        Row(modifier = Modifier.fillMaxWidth()) {
//            Column(modifier = Modifier
//                .fillMaxWidth()
//                .padding(start = 20.dp)) {
//                Text(text = "Descripcion")
//                Text(text = material.description, fontSize = 20.sp, fontWeight = FontWeight.Bold)
//            }
//
//        }
//
//    }
//}


@Composable
fun MaterialInfo(material: Material) {
    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        Text("Temática", style = MaterialTheme.typography.labelLarge)
        Text(material.asignatura, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Text("Curso", style = MaterialTheme.typography.labelLarge)
        Text(material.curso, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Text("Cantidad", style = MaterialTheme.typography.labelLarge)
        Text("${material.cantidad} unidades", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Text("Descripción", style = MaterialTheme.typography.labelLarge)
        ExpandDescripcion(
            text = material.description,
            textStyle = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold)
        )
    }
}