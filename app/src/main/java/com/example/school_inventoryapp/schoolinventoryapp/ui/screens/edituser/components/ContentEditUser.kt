package com.example.school_inventoryapp.schoolinventoryapp.ui.screens.edituser.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.school_inventoryapp.schoolinventoryapp.data.dataInfo.User
import com.example.school_inventoryapp.schoolinventoryapp.ui.screens.signup.components.AvatarsSignUp
import com.example.school_inventoryapp.schoolinventoryapp.ui.screens.signup.components.ClasesSignUp
import com.example.school_inventoryapp.schoolinventoryapp.ui.components.ProgressIndicatorLogo
import com.example.school_inventoryapp.schoolinventoryapp.ui.screens.signup.components.CentroSignUp
import com.example.school_inventoryapp.schoolinventoryapp.ui.screens.signup.components.NameSignUp
import com.example.school_inventoryapp.schoolinventoryapp.ui.viewmodels.SignUpViewModel



@Composable
fun ContentEditUser(
    singUpViewModel: SignUpViewModel,
    userName: String,
    email: String,
    avatar: String,
    clase: String,
    centro: String,
    password1: String,
    password2: String,
    paddingValues: PaddingValues
) {

    val isLoading: Boolean by singUpViewModel.isLoading.observeAsState(false)

    LaunchedEffect(Unit) {
        singUpViewModel.getAvatars()
    }


    if (isLoading) {
        Box(
            modifier = Modifier
                .fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            ProgressIndicatorLogo()
        }
    } else {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(paddingValues)
        ) {

            Column(
                verticalArrangement = Arrangement.spacedBy(20.dp),
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(bottom = 80.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                NameEditUser(
                    userName,
                    email,
                    avatar,
                    clase,
                    centro,
                    password1,
                    password2,
                    singUpViewModel
                )
                AvatarsEditUser(
                    userName,
                    email,
                    avatar,
                    clase,
                    centro,
                    password1,
                    password2,
                    singUpViewModel
                )
                ClasesEditUser(
                    userName,
                    email,
                    avatar,
                    clase,
                    centro,
                    password1,
                    password2,
                    singUpViewModel
                )
                CentroEditUser(
                    userName,
                    email,
                    avatar,
                    clase,
                    centro,
                    password1,
                    password2,
                    singUpViewModel
                )
            }
        }
    }
}

