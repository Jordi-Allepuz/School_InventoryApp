package com.example.school_inventoryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.school_inventoryapp.schoolinventoryapp.ui.screens.appinfo.InfoAppScreen
import com.example.school_inventoryapp.schoolinventoryapp.ui.screens.edituser.EditUserScreen
import com.example.school_inventoryapp.schoolinventoryapp.ui.screens.login.LoginScreen
import com.example.school_inventoryapp.schoolinventoryapp.ui.screens.materialslist.MaterialsListScreen
import com.example.school_inventoryapp.schoolinventoryapp.ui.screens.signup.SignUpScreen
import com.example.school_inventoryapp.schoolinventoryapp.ui.screens.userinfo.UserInfoScreen
import com.example.school_inventoryapp.schoolinventoryapp.ui.viewmodels.LoginViewModel
import com.example.school_inventoryapp.schoolinventoryapp.ui.viewmodels.MaterialsInfoViewModel
import com.example.school_inventoryapp.schoolinventoryapp.ui.viewmodels.OpenAppsViewModel
import com.example.school_inventoryapp.schoolinventoryapp.ui.viewmodels.SignUpViewModel
import com.example.school_inventoryapp.schoolinventoryapp.ui.viewmodels.UserInfoViewModel
import com.example.school_inventoryapp.ui.theme.School_InventoryAppTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val loginViewModel: LoginViewModel by viewModels()
    private val signUpViewModel: SignUpViewModel by viewModels()
    private val userInfoViewModel: UserInfoViewModel by viewModels()
    private val openAppsViewModel: OpenAppsViewModel by viewModels()
    private val materialsInfoViewModel: MaterialsInfoViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            School_InventoryAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navigationController = rememberNavController()
                    NavHost(
                        navController = navigationController,
                        startDestination = loginViewModel.checkDestination()
                    ) {
                        composable(Routes.LoginScreen.route) {
                            LoginScreen(loginViewModel, navigationController)
                        }
                        composable(Routes.SignUpScreen.route) {
                            SignUpScreen(signUpViewModel, navigationController)
                        }
                        composable(Routes.EditUserScreen.route) {
                            EditUserScreen(signUpViewModel, userInfoViewModel, navigationController)
                        }
                        composable(Routes.UserInfoScreen.route) {
                            UserInfoScreen(
                                userInfoViewModel,
                                loginViewModel,
                                openAppsViewModel,
                                navigationController
                            )
                        }
                        composable(Routes.MaterialInfoScreen.route) {

                        }
                        composable(Routes.MaterialListScreen.route) {
                            MaterialsListScreen(
                                userInfoViewModel,
                                loginViewModel,
                                openAppsViewModel,
                                materialsInfoViewModel,
                                navigationController
                            )
                        }
                        composable(Routes.MaterialCreateScreen.route) {

                        }
                        composable(Routes.AppInfoScreen.route) {
                            InfoAppScreen(
                                loginViewModel,
                                userInfoViewModel,
                                openAppsViewModel,
                                navigationController
                            )
                        }
                    }
                }
            }
        }
    }
}
