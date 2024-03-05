package com.example.school_inventoryapp.schoolinventoryapp.ui.screens.userinfo.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Apartment
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.rounded.Apartment
import androidx.compose.material.icons.rounded.School
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.school_inventoryapp.schoolinventoryapp.data.dataInfo.User

@Composable
fun UserInfo(user: User) {
    Column() {
        Row(modifier= Modifier.fillMaxWidth()) {
            Icon(modifier= Modifier.size(50.dp),imageVector = Icons.Default.Email , contentDescription ="email" )
            Column() {
                Text(text= "Correo Electronico")
                Text(text= user.email, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }
        }
        Row(modifier= Modifier.fillMaxWidth()) {
            Icon(modifier= Modifier.size(50.dp),imageVector =  Icons.Default.Apartment , contentDescription = "centro")
            Column() {
                Text(text= "Centro de trabajo")
                Text(text= user.centro, fontSize = 20.sp, fontWeight = FontWeight.Bold )
            }

        }
        Row(modifier= Modifier.fillMaxWidth()) {
            Icon(modifier= Modifier.size(50.dp),imageVector = Icons.Default.School, contentDescription = "clase" )
            Column() {
                Text(text= "Curso")
                Text(text= user.clase, fontSize = 20.sp, fontWeight = FontWeight.Bold )
            }

        }

    }
}