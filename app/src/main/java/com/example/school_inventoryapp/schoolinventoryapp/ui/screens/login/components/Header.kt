package com.example.school_inventoryapp.schoolinventoryapp.ui.screens.login.components

import android.app.Activity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

/*HEADER*/
@Composable
fun Header() {
    val activity = LocalContext.current as Activity
    Row(modifier= Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End, verticalAlignment = Alignment.Top) {
        Icon(
            imageVector = Icons.Default.Close,
            contentDescription = "close app",
            tint = Color.Black,
            modifier = Modifier.clickable { activity.finish() })
    }
}
