package com.example.school_inventoryapp.schoolinventoryapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.school_inventoryapp.schoolinventoryapp.data.sources.remote.StorageService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class UserInfoViewModel @Inject constructor(private val storageService: StorageService) : ViewModel(){
}