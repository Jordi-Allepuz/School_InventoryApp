package com.example.school_inventoryapp.schoolinventoryapp.ui.screens.appinfo.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.school_inventoryapp.R

@Composable
fun ContentAppInfoScreen() {
    Column(modifier= Modifier.fillMaxSize().verticalScroll(rememberScrollState())) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(3f)
        ) {
            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxSize(), verticalArrangement = Arrangement.Center
            ) {
                Divider(thickness = 4.dp)
                Text(
                    text = "Autor: Jordi Allepuz Janoher",
                    modifier = Modifier.padding(10.dp),
                    fontSize = 20.sp,
                    color = Color.Black
                )
                Divider(thickness = 4.dp)
                Text(
                    text = "Nombre App: School Inventory",
                    modifier = Modifier.padding(10.dp),
                    fontSize = 20.sp,
                    color = Color.Black
                )
                Divider(thickness = 4.dp)
                Text(
                    text = "Version: 1.0",
                    modifier = Modifier.padding(10.dp),
                    fontSize = 20.sp,
                    color = Color.Black
                )
                Divider(thickness = 4.dp)
                Text(
                    text = "Contacto: joralljan@alu.edu.gva.es ",
                    modifier = Modifier.padding(10.dp),
                    fontSize = 20.sp,
                    color = Color.Black
                )
                Divider(thickness = 4.dp)
                Text(
                    text = "Curso: 2CFSF DAM ",
                    modifier = Modifier.padding(10.dp),
                    fontSize = 20.sp,
                    color = Color.Black
                )
                Divider(thickness = 4.dp)
            }
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
        )
        {
            Row(
                verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, start = 16.dp)
            ) {
                var show by remember { mutableStateOf(false) }
                LaunchedEffect(key1 = Unit) {
                    show = true
                }
                val scale by animateFloatAsState(
                    targetValue = if (show) 1f else 0f,
                    animationSpec = tween(durationMillis = 1500, easing = LinearOutSlowInEasing)
                )
                Image(
                    painter = painterResource(id = R.drawable.jordiphoto),
                    contentDescription = "photoperfil",
                    Modifier
                        .size(80.dp)
                        .graphicsLayer {
                            scaleX = scale
                            scaleY = scale
                        }
                        .clip(CircleShape), contentScale = ContentScale.Crop
                )
                AnimatedVisibility(
                    visible = show,
                    enter = slideInHorizontally(
                        initialOffsetX = { it },
                        animationSpec = tween(durationMillis = 1500)
                    )
                ) {
                    Text(
                        text = "JORDI ALLEPUZ JANOHER",
                        Modifier.padding(start = 8.dp),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                }
            }
        }
    }
}



