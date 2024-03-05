package com.example.school_inventoryapp.schoolinventoryapp.ui.viewmodels

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


@HiltViewModel
class UserInfoViewModel @Inject constructor(
    private val storageService: StorageService,
    private val authService: AuthService
) :
    ViewModel() {

    private val _user = MutableLiveData<User>(null)
    val user: LiveData<User> = _user

    private val _dateJoin = MutableLiveData<String>()
    val dateJoin: LiveData<String> = _dateJoin

    private val _currentUserEmail = MutableLiveData<String>()
    val currentUserEmail: LiveData<String> = _currentUserEmail


    // Método para obtener la información del usuario actual utilizando el email.
    fun getInfoUser() {
        viewModelScope.launch {
            _currentUserEmail.value = authService.getCurrentUser()?.email
            val result = withContext(Dispatchers.IO) {
                storageService.getInfoUser(_currentUserEmail.value!!)
            }
            if (result != null) {
                _user.value = result
            } else {
                //error
            }
        }
    }

    // Método para obtener la fecha de creación del usuario actual.
    fun getCreationDate() {
        viewModelScope.launch {
            _dateJoin.value = authService.getCreationDate()
        }
    }







}