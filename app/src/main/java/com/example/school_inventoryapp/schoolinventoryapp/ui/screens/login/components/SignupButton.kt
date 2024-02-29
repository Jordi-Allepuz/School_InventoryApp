package com.example.school_inventoryapp.schoolinventoryapp.ui.screens.login.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.school_inventoryapp.Routes

@Composable
fun SignUpBottom(
    navigationController: NavHostController
) {
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "¿No tienes una cuenta?", fontSize = 12.sp, color = Color.Black, fontWeight = FontWeight.Bold)
        Button(
            onClick = {
                navigationController.navigate(Routes.SignUpScreen.route)
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFe4bc7f),
                contentColor = Color.White,
            )
        ) {
            Text(text = "Regístrate")
        }
        Spacer(modifier = Modifier.size(60.dp))
    }

}


