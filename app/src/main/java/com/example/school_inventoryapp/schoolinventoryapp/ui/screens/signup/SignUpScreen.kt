package com.example.school_inventoryapp.schoolinventoryapp.ui.screens.signup

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
import com.example.school_inventoryapp.schoolinventoryapp.ui.components.DropDownMenuClases
import com.example.school_inventoryapp.schoolinventoryapp.ui.components.ProgressIndicatorLogo
import com.example.school_inventoryapp.schoolinventoryapp.ui.screens.signup.components.Centro
import com.example.school_inventoryapp.schoolinventoryapp.ui.screens.signup.components.Email
import com.example.school_inventoryapp.schoolinventoryapp.ui.screens.signup.components.Nombre
import com.example.school_inventoryapp.schoolinventoryapp.ui.screens.signup.components.Password1
import com.example.school_inventoryapp.schoolinventoryapp.ui.screens.signup.components.Password2
import com.example.school_inventoryapp.schoolinventoryapp.ui.viewmodels.SignUpViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SignUpScreen(
    signUpViewModel: SignUpViewModel,
    navController: NavHostController,
) {

    val email: String by signUpViewModel.email.observeAsState(initial = "")
    val userName: String by signUpViewModel.userName.observeAsState(initial = "")
    val password1: String by signUpViewModel.password1.observeAsState(initial = "")
    val password2: String by signUpViewModel.password2.observeAsState(initial = "")
    val clase: String by signUpViewModel.clase.observeAsState(initial = "")
    val centro: String by signUpViewModel.centro.observeAsState(initial = "")
    val isSignUpEnable: Boolean by signUpViewModel.isSignUpEnable.observeAsState(initial = false)


    Scaffold(
        topBar = {/*empty*/ },
        content = { paddingValues ->
            ContentNewUSer(
                signUpViewModel,
                userName,
                email,
                clase,
                centro,
                password1,
                password2,
                paddingValues,
            )
        },
        bottomBar = { /*empty*/ },
        floatingActionButton = {
            FabNewUser(
                navController,
                signUpViewModel,
                userName,
                email,
                clase,
                centro,
                password1,
                isSignUpEnable
            )
        },
        floatingActionButtonPosition = FabPosition.End,
    )
}


@Composable
fun FabNewUser(
    navController: NavHostController,
    singUpViewModel: SignUpViewModel,
    userName: String,
    email: String,
    clase:String,
    centro: String,
    password1: String,
    isSignUpEnable: Boolean,
) {
    val contentToast = LocalContext.current.applicationContext
    FloatingActionButton(
        onClick = {
            if (isSignUpEnable) {
                Toast.makeText(
                    contentToast,
                    "REGISTRADO",
                    Toast.LENGTH_LONG
                ).show()
                singUpViewModel.registerUser(
                       userName,
                        email,
                        clase,
                        centro
                )
                singUpViewModel.signUp(
                    email,
                    password1
                ) { navController.navigate(Routes.UserInfoScreen.route) }
            } else {
                Toast.makeText(
                    contentToast,
                    "REVISA LOS CAMPOS",
                    Toast.LENGTH_LONG
                ).show()
            }
        }, contentColor = Color.Black, containerColor = Color(0xFFe4bc7f)
    ) {
        Icon(imageVector = Icons.Rounded.Add, contentDescription = "check")
    }
}


@Composable
fun ContentNewUSer(
    singUpViewModel: SignUpViewModel,
    userName: String,
    email: String,
    clase: String,
    centro: String,
    password1: String,
    password2: String,
    paddingValues: PaddingValues,
) {


    var passwordVisibility by rememberSaveable { mutableStateOf(true) }
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
                Nombre(
                    userName,
                    email,
                    clase,
                    centro,
                    password1,
                    password2,
                    singUpViewModel
                )
                Email(
                    userName,
                    email,
                    clase,
                    centro,
                    password1,
                    password2,
                    singUpViewModel
                )
                DropDownMenuClases(
                    userName,
                    email,
                    clase,
                    centro,
                    password1,
                    password2,
                    singUpViewModel
                )
                Centro(
                    userName,
                    email,
                    clase,
                    centro,
                    password1,
                    password2,
                    singUpViewModel
                )
                Password1(
                    userName,
                    email,
                    clase,
                    centro,
                    password1,
                    password2,
                    singUpViewModel,
                    passwordVisibility,
                    setPasswordVisibility = { passwordVisibility = it }
                )
                Password2(
                    userName,
                    email,
                    clase,
                    centro,
                    password1,
                    password2,
                    singUpViewModel,
                    passwordVisibility,
                    setPasswordVisibility = { passwordVisibility = it }
                )
            }
        }
    }
}




