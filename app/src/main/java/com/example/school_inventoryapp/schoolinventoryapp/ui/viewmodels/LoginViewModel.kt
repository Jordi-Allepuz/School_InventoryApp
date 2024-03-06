package com.example.school_inventoryapp.schoolinventoryapp.ui.viewmodels

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.school_inventoryapp.Routes
import com.example.school_inventoryapp.schoolinventoryapp.data.sources.remote.AuthService
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(private val authService: AuthService) : ViewModel() {

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password


    private val _isLoginEnable = MutableLiveData<Boolean>()
    val isLoginEnable: LiveData<Boolean> = _isLoginEnable


    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading


    fun onLoginChange(email: String, password: String) {
        _email.value = email
        _password.value = password
        _isLoginEnable.value = enableLogin(email, password)
    }


    // Valida el correo electrónico y la longitud de la contraseña para habilitar el inicio de sesión.
    fun enableLogin(email: String, password: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length > 6
    }


    // Inicia sesión con el correo electrónico y la contraseña proporcionados.
    fun login(email: String, password: String, toUserScreen: () -> Unit) {
        viewModelScope.launch {
            _isLoading.value = true
            try{
                val result = withContext(Dispatchers.IO) {
                    authService.login(email, password)
                }
                if (result != null) {
                    toUserScreen()
                    _email.value = ""
                    _password.value = ""
                    _isLoginEnable.value= false
                    Log.i("Current User Email", "${authService.getCurrentUser()!!.email}")
                } else {
                    //
                }
            }catch (e:Exception){
                //
            }
            _isLoading.value = false
        }
    }


    // Cierra la sesión del usuario actual
    fun logOut(toLoginScreen: () -> Unit) {
        viewModelScope.launch {
            authService.logOut()
            _email.value = ""
            _password.value = ""

            toLoginScreen()
        }
    }


    // Comprueba si el usuario está actualmente logueado.
    fun isUserLogged():Boolean{
        return  authService.isUserLogged()
    }


    // Determina la ruta de navegación inicial basada en si el usuario está logueado o no.
    fun checkDestination():String{
        val isUserLogged = isUserLogged()
        return if (isUserLogged){
            Routes.UserInfoScreen.route
        }else{
            Routes.LoginScreen.route
        }
    }

}