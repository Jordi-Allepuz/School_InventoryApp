package com.example.school_inventoryapp.schoolinventoryapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Face
import androidx.compose.material.icons.rounded.School
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.school_inventoryapp.schoolinventoryapp.ui.data.listaClases
import com.example.school_inventoryapp.schoolinventoryapp.ui.viewmodels.SignUpViewModel
import com.example.school_inventoryapp.schoolinventoryapp.ui.viewmodels.UserInfoViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDownMenuAvatars(
    userName: String,
    email: String,
    avatar: String,
    clase: String,
    centro: String,
    password1: String,
    password2: String,
    singUpViewModel: SignUpViewModel
) {

    // Estado para controlar si el menú desplegable está expandido o no.
    var expanded by remember { mutableStateOf(false) }
    var enable by remember { mutableStateOf(false) }
    // Lista de cursos que hay en el centro educativo.
    val avatars: List<String> by singUpViewModel.avatars.observeAsState(initial = listOf())

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F2F2))) {
            Image(
                painter = rememberImagePainter(data = avatar),
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
                    .padding(vertical = 2.dp)
            )
        }
        OutlinedTextField(
            value = "",
            shape = RoundedCornerShape(10.dp),
            enabled = enable,
            onValueChange = {
                singUpViewModel.onLoginChange(
                    userName,
                    email,
                    it,
                    clase,
                    centro,
                    password1,
                    password2,
                )
            },
            label = {
                Text(
                    text = "Selecciona un avatar",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Rounded.Face,
                    contentDescription = "avatar"
                )
            },
            readOnly = true,
            modifier = Modifier
                .size(300.dp, 60.dp)
                .clickable {
                    enable = false
                    expanded = true
                },
            singleLine = true,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                disabledTextColor = Color.Black,
                disabledBorderColor = Color.Transparent,
                disabledLeadingIconColor = MaterialTheme.colorScheme.outline ,
                containerColor = Color(0xFFF5F2F2),
                unfocusedBorderColor = Color.Transparent,
                focusedBorderColor = Color.Transparent
            )
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .size(300.dp)
                .fillMaxHeight()
        ) {
            avatars.forEach { avatar ->
                DropdownMenuItem(onClick = {
                    singUpViewModel.onLoginChange(
                        userName,
                        email,
                        avatar,
                        clase,
                        centro,
                        password1,
                        password2,
                    )
                    expanded = false
                },
                    text = {
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Image(
                                painter = rememberImagePainter(data = avatar),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(60.dp)
                                    .padding(vertical = 2.dp)
                            )
                        }
                    })

            }
        }
    }
}