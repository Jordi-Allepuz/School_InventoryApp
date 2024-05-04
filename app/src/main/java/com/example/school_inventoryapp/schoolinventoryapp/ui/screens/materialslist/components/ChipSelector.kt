package com.example.school_inventoryapp.schoolinventoryapp.ui.screens.materialslist.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Chip(title: String, isSelected: Boolean, onClick: () -> Unit) {
    Surface(
        modifier = Modifier
            .padding(horizontal = 4.dp)
            .clickable(onClick = onClick),
        shadowElevation = 4.dp,
        shape = MaterialTheme.shapes.small,
        color = if (isSelected) Color.Red.copy(alpha = 0.5f) else Color.Transparent
    ) {
        Text(
            text = title,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            fontSize = 16.sp
        )
    }
}