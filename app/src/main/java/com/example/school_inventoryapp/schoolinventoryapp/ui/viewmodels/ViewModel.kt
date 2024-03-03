package com.example.school_inventoryapp.schoolinventoryapp.ui.viewmodels

import ShopRepositoryImpl
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.school_inventoryapp.schoolinventoryapp.domain.repositories.EmailRepositoryImpl
import com.example.school_inventoryapp.schoolinventoryapp.domain.usecases.UsesCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor(private val useCases: UsesCases): ViewModel() {


    // Método para visitar la tienda online.
    fun visitShop(url:String){
        viewModelScope.launch {
            useCases.executeShop(url)
        }
    }


    // Método para enviar un correo electrónico.
    fun sendEmail(emailAdress:String){
        viewModelScope.launch {
            useCases.executeEmail(emailAdress)
        }
    }

}