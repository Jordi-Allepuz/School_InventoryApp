package com.example.school_inventoryapp.schoolinventoryapp.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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


@Composable
fun EditButton( titulo: String, navegar: () -> Unit) {
    Button(
        onClick = { navegar() },
        modifier = Modifier
            .size(400.dp, 50.dp)
            .padding(horizontal = 15.dp),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFF5F2F2),
            contentColor = Color.Black
        ),
    )
    {
        Text(
            text = titulo,
            fontWeight = FontWeight.ExtraBold,
            color = Color.Black,
            fontSize = 18.sp
        )
    }
}


