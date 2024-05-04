package com.example.school_inventoryapp.schoolinventoryapp.ui.screens.materialinfo.components

import androidx.compose.animation.core.animateInt
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun ExpandDescripcion(
    text: String,
    collapsedMaxLines: Int = 3,
    textStyle: TextStyle,
) {
    var expanded by remember { mutableStateOf(false) }
    val maxLines = if (expanded) Int.MAX_VALUE else collapsedMaxLines

    Column(modifier = Modifier.clickable { expanded = !expanded }) {
        Text(
            text = text,
            maxLines = maxLines,
            overflow = TextOverflow.Ellipsis,
            style = textStyle,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = if (expanded) "Ver menos" else "Ver mas",
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.align(Alignment.End),
            style = textStyle,
        )
    }
}