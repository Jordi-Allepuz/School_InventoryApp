package com.example.school_inventoryapp.schoolinventoryapp.ui.screens.edituser

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavHostController
import com.example.school_inventoryapp.schoolinventoryapp.data.dataInfo.User
import com.example.school_inventoryapp.schoolinventoryapp.ui.screens.edituser.components.ContentEditUser
import com.example.school_inventoryapp.schoolinventoryapp.ui.screens.edituser.components.FabEditUser
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

    val user: User? by userInfoViewModel.user.observeAsState()

    val userName: String by signUpViewModel.userName.observeAsState(initial = user!!.nombre)
    val avatar: String by signUpViewModel.avatar.observeAsState(initial = user!!.avatar)
    val clase: String by signUpViewModel.clase.observeAsState(initial = user!!.clase)
    val centro: String by signUpViewModel.centro.observeAsState(initial = user!!.centro)
    val password1: String by signUpViewModel.password1.observeAsState(initial = "")
    val password2: String by signUpViewModel.password2.observeAsState(initial = "")



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
                paddingValues
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




