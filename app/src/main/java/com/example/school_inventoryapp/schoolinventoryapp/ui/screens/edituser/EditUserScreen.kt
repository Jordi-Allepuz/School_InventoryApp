package com.example.school_inventoryapp.schoolinventoryapp.ui.screens.edituser

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.school_inventoryapp.Routes
import com.example.school_inventoryapp.schoolinventoryapp.data.dataInfo.User
import com.example.school_inventoryapp.schoolinventoryapp.ui.components.DropDownMenuAvatars
import com.example.school_inventoryapp.schoolinventoryapp.ui.components.DropDownMenuClases
import com.example.school_inventoryapp.schoolinventoryapp.ui.components.ProgressIndicatorLogo
import com.example.school_inventoryapp.schoolinventoryapp.ui.screens.edituser.components.ContentEditUser
import com.example.school_inventoryapp.schoolinventoryapp.ui.screens.edituser.components.FabEditUser
import com.example.school_inventoryapp.schoolinventoryapp.ui.screens.signup.components.Centro
import com.example.school_inventoryapp.schoolinventoryapp.ui.screens.signup.components.Email
import com.example.school_inventoryapp.schoolinventoryapp.ui.screens.signup.components.Nombre
import com.example.school_inventoryapp.schoolinventoryapp.ui.screens.signup.components.Password1
import com.example.school_inventoryapp.schoolinventoryapp.ui.screens.signup.components.Password2
import com.example.school_inventoryapp.schoolinventoryapp.ui.viewmodels.SignUpViewModel
import com.example.school_inventoryapp.schoolinventoryapp.ui.viewmodels.UserInfoViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun EditUserScreen(
    signUpViewModel: SignUpViewModel,
    userInfoViewModel: UserInfoViewModel,
    navController: NavHostController,
) {

    val email: String by signUpViewModel.email.observeAsState(initial = "")
    val userName: String by signUpViewModel.userName.observeAsState(initial = "")
    val avatar: String by signUpViewModel.avatar.observeAsState(initial = "")
    val clase: String by signUpViewModel.clase.observeAsState(initial = "")
    val centro: String by signUpViewModel.centro.observeAsState(initial = "")
    val password1: String by signUpViewModel.password1.observeAsState(initial = "")
    val password2: String by signUpViewModel.password2.observeAsState(initial = "")

    val user: User? by userInfoViewModel.user.observeAsState()

    Scaffold(
        topBar = {/*empty*/ },
        content = { paddingValues ->
            ContentEditUser(
                signUpViewModel,
                userName,
                user!!.email,
                avatar,
                clase,
                centro,
                password1,
                password2,
                paddingValues,
            )
        },
        bottomBar = { /*empty*/ },
        floatingActionButton = {
            FabEditUser(
                navController,
                signUpViewModel,
                userName,
                user!!.email,
                avatar,
                clase,
                centro,
            )
        },
        floatingActionButtonPosition = FabPosition.End,
    )
}




