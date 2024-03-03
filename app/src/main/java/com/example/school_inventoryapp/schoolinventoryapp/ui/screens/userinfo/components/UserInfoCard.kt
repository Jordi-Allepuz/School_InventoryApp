package com.example.school_inventoryapp.schoolinventoryapp.ui.screens.userinfo.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.school_inventoryapp.schoolinventoryapp.data.dataInfo.User


@OptIn(ExperimentalCoilApi::class)
@Composable
fun UserInfoCard(user: User) {
    Column(
        Modifier
            .fillMaxWidth()
            .border(2.dp, Color.Black, RoundedCornerShape(4.dp))
            .padding(9.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = rememberImagePainter(data = user.avatar),
            contentDescription = null,
            modifier = Modifier.size(120.dp)
        )
        Text(
            text = "Nombre: ${user.nombre}",
            color = Color.Black,
            fontWeight = FontWeight.ExtraBold
        )
        Text(
            text = "Centro Educativo: ${user.centro}",
            color = Color.Black,
            fontWeight = FontWeight.ExtraBold
        )
        Text(
            text = "Clase: ${user.clase}",
            color = Color.Black,
            fontWeight = FontWeight.ExtraBold
        )
    }
}


