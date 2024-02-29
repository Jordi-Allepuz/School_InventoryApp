package com.example.school_inventoryapp.schoolinventoryapp.ui.screens.login.components

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.school_inventoryapp.R


/*LOGO*/
@Composable
fun ImageLogo(modifier: Modifier) {
    var show by remember { mutableStateOf(false) }
    LaunchedEffect(key1 = Unit) {
        show = true
    }
    val scale by animateFloatAsState(
        targetValue = if (show) 1f else 0f,
        animationSpec = tween(durationMillis = 1000, easing = LinearOutSlowInEasing)
    )
    Image(
        painter = painterResource(id = R.drawable.applogo),
        contentDescription = "logo", modifier = modifier
            .size(150.dp)
            .graphicsLayer {
                scaleX = scale
                scaleY = scale
            }
            .clip(CircleShape)
    )
}
