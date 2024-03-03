package com.example.school_inventoryapp.schoolinventoryapp.domain.repositories

interface EmailRepository {
    suspend fun visitEmail(emailAddress: String)
}
