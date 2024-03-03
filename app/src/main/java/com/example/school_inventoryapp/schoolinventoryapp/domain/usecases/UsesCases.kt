package com.example.school_inventoryapp.schoolinventoryapp.domain.usecases

import com.example.school_inventoryapp.schoolinventoryapp.domain.repositories.EmailRepositoryImpl
import com.example.school_inventoryapp.schoolinventoryapp.domain.repositories.ShopRepositoryImpl
import javax.inject.Inject

class UsesCases @Inject constructor(private val shopRepositoryImpl: ShopRepositoryImpl, private val emailRepositoryImpl: EmailRepositoryImpl) {


    suspend fun executeShop (url:String){
        shopRepositoryImpl.visitShop(url)
    }

    suspend fun executeEmail (emailAddress:String){
        emailRepositoryImpl.visitEmail(emailAddress)
    }
}