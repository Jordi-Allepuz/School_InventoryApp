package com.example.school_inventoryapp.schoolinventoryapp.domain.repositories

interface ShopRepository {
    suspend fun visitShop(url:String)
}