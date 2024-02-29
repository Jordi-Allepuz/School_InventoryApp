package com.example.school_inventoryapp.schoolinventoryapp.ui.viewmodels

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.school_inventoryapp.schoolinventoryapp.data.dataInfo.User
import com.example.school_inventoryapp.schoolinventoryapp.data.sources.remote.AuthService
import com.example.school_inventoryapp.schoolinventoryapp.data.sources.remote.StorageService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.random.Random


@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val authService: AuthService,
    private val storageService: StorageService
) : ViewModel() {


    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _userName = MutableLiveData<String>()
    val userName: LiveData<String> = _userName

    private val _password1 = MutableLiveData<String>()
    val password1: LiveData<String> = _password1

    private val _password2 = MutableLiveData<String>()
    val password2: LiveData<String> = _password2

    private val _clase = MutableLiveData<String>()
    val clase: LiveData<String> = _clase

    private val _centro = MutableLiveData<String>()
    val centro: LiveData<String> = _centro

    private val _avatar = MutableLiveData<MutableList<String>>()
    val avatar: LiveData<MutableList<String>> = _avatar

    private val _isSignUpEnable = MutableLiveData<Boolean>()
    val isSignUpEnable: LiveData<Boolean> = _isSignUpEnable

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading


    // Actualiza los LiveData con los valores ingresados y valida si el formulario está listo para enviar.
    fun onLoginChange(
        userName: String,
        email: String,
        clase: String,
        centro: String,
        password1: String,
        password2: String,

        ) {
        _userName.value = userName
        _email.value = email
        _clase.value = clase
        _centro.value = centro
        _password1.value = password1
        _password2.value = password2
        _isSignUpEnable.value = enableSignUp(email, password1, password2)
    }


    // Valida el correo electrónico y las contraseñas para habilitar el registro.
    fun enableSignUp(
        email: String,
        password1: String,
        password2: String,
    ): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email)
            .matches() && password1.length > 6 && password2.length > 6 &&
                password1 == password2
    }


    // Realiza el registro del usuario en FirebaseAuth.
    fun signUp(
        email: String,
        password: String,
        toUserScreen: () -> Unit

    ) {
        viewModelScope.launch {
            _isLoading.value = true
            val result = withContext(Dispatchers.IO) {
                authService.signUp(email, password)
            }
            if (result != null) {
                toUserScreen()
            } else {
                //error
            }
            _isLoading.value = false
        }
    }


    // Registra los datos adicionales del usuario en Firestore.
    fun registerUser(
        userName: String,
        email: String,
        clase: String,
        centro: String
    ) {
        viewModelScope.launch {
            _isLoading.value = true
            val result = withContext(Dispatchers.IO) {
                val randomPhoto = Random.nextInt(0, _avatar.value!!.size)
                val avatar: String = _avatar.value!![randomPhoto]

                val idNueva = storageService.getLastId() + 1

                storageService.createNewUser(
                    User(
                        idNueva,
                        userName,
                        email,
                        clase,
                        centro,
                        avatar
                    )
                )
            }
            if (result != null) {
                _userName.value = ""
                _email.value = ""
                _clase.value = ""
                _centro.value = ""
                _password1.value = ""
                _password2.value = ""
                //
            } else {
                //error
            }
            _isLoading.value = false
        }
    }



    // Obtiene las fotos disponibles para el usuario desde Firebase Storage.
    fun getAvatars() {
        viewModelScope.launch {
            _isLoading.value = true
            val result = withContext(Dispatchers.IO) {
                storageService.getAvatars()
            }
            if (result != null) {
                _avatar.value = result
            } else {
                //
            }
            _isLoading.value = false
        }
    }


}