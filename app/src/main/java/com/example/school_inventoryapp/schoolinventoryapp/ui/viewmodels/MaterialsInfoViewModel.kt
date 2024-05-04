package com.example.school_inventoryapp.schoolinventoryapp.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.school_inventoryapp.schoolinventoryapp.data.dataInfo.Material
import com.example.school_inventoryapp.schoolinventoryapp.data.dataInfo.User
import com.example.school_inventoryapp.schoolinventoryapp.data.sources.remote.StorageService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Math.log
import javax.inject.Inject


@HiltViewModel
class MaterialsInfoViewModel @Inject constructor(private val storageService: StorageService) :
    ViewModel() {

    private val _material = MutableLiveData<Material>()
    val material: LiveData<Material> = _material

    private val _materialList = MutableLiveData<MutableList<Material>>()
    val materialList: LiveData<MutableList<Material>> = _materialList

    private val _nombreMaterial = MutableLiveData<String>()
    val nombreMaterial: LiveData<String> = _nombreMaterial

    private val _cantidadMaterial = MutableLiveData<String>()
    val cantidadMaterial: LiveData<String> = _cantidadMaterial

    private val _asignaturaMaterial = MutableLiveData<String>()
    val asignaturaMaterial: LiveData<String> = _asignaturaMaterial

    private val _cursoMaterial = MutableLiveData<String>()
    val cursoMaterial: LiveData<String> = _cursoMaterial

    private val _descriptionMaterial = MutableLiveData<String>()
    val descriptionMaterial: LiveData<String> = _descriptionMaterial

    private val _imageMaterial = MutableLiveData<String>()
    val imageMaterial: LiveData<String> = _imageMaterial

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading


    // Método para obtener la información de un material específico.
    fun getMaterialInfo(name: String) {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                storageService.getMaterialInfo(name)
            }
            if (result != null) {
                _material.value = result
            } else {
                //error
            }
        }
    }


    // Método para obtener todos los materiales disponibles.
    fun getMaterialList() {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                storageService.getMaterialsList()
            }
            _materialList.value = result
        }
    }

    // Método para obtener los materiales filtrados por asignatura.
    fun getMaterialsBySubject(subject: String) {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                storageService.getMaterialsBySubject(subject)
            }
            _materialList.value = result
        }
    }


    fun onCreateChange(
        nombreMaterial: String,
        cantidadMaterial: String,
        cursoMaterial: String,
        asignaturaMaterial: String,
        descriptionMaterial: String,
        imageMaterial: String
    ) {
        _nombreMaterial.value = nombreMaterial
        _cantidadMaterial.value = cantidadMaterial
        _cursoMaterial.value = cursoMaterial
        _asignaturaMaterial.value = asignaturaMaterial
        _descriptionMaterial.value = descriptionMaterial
        _imageMaterial.value = imageMaterial
    }


    // Método para añadir un nuevo material.
    fun addMaterial(
        nombreMaterial: String,
        cantidadMateria: String,
        cursoMateria: String,
        asignaturaMaterial: String,
        descriptionMaterial: String,
        imageMaterial: String
    ) {
        viewModelScope.launch {
            _isLoading.value = true
            val result = withContext(Dispatchers.IO) {
                storageService.addMaterial(
                    Material(
                        nombreMaterial,
                        cantidadMateria,
                        cursoMateria,
                        asignaturaMaterial,
                        descriptionMaterial,
                        imageMaterial
                    )
                )
            }
            if (result) {
                //
            } else {
                //
            }
            _isLoading.value = false
        }
    }

    fun updateMaterial(
        nombre: String,
        cantidad: String,
        curso: String,
        asignatura: String,
        description: String,
        imagen: String,
        onSuccess: () -> Unit
    ) {
        viewModelScope.launch {
            _isLoading.value = true
            val result = withContext(Dispatchers.IO) {
                storageService.editMaterial(
                    Material(
                        nombre,
                        cantidad,
                        curso,
                        asignatura,
                        description,
                        imagen
                    ), nombre
                )
            }
            if (result != null) {
                onSuccess()
            } else {
                //
            }
            _isLoading.value = false
        }
    }


}