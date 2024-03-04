package com.example.school_inventoryapp.schoolinventoryapp.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.school_inventoryapp.schoolinventoryapp.data.dataInfo.Material
import com.example.school_inventoryapp.schoolinventoryapp.data.sources.remote.StorageService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class MaterialsInfoViewModel @Inject constructor(private val storageService: StorageService) : ViewModel(){

    private val _material = MutableLiveData<Material>()
    val material: LiveData<Material> = _material

    private val _materialList = MutableLiveData<MutableList<Material>>()
    val materialList: LiveData<MutableList<Material>> = _materialList



    // Método para obtener la información de un libro específico.
    fun getMaterialInfo (name: String, toInfo: () -> Unit) {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                storageService.getMaterialInfo(name)
            }
            if (result != null) {
                _material.value = result
                toInfo()
            } else {
                //error
            }
        }
    }


    // Método para obtener todos los libros disponibles.
    fun getMaterialList(toList: () -> Unit) {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                storageService.getMaterialsList()
            }
            _materialList.value = result
            toList()
        }
    }



}