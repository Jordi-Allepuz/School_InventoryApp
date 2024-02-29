package com.example.school_inventoryapp.schoolinventoryapp.data.sources.remote

import com.example.school_inventoryapp.schoolinventoryapp.data.dataInfo.User
import com.example.school_inventoryapp.schoolinventoryapp.data.mappers.userToMap
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class StorageService @Inject constructor(
    private val firebaseStorage: FirebaseStorage,
    private val firebaseFirestore: FirebaseFirestore
) {


    // Registra los datos de un usuario en Firestore
    suspend fun registredUserData(user: User): Boolean {
        val usuarioMap = userToMap(user)
        return firebaseFirestore.collection("usuarios").add(usuarioMap).isComplete
    }


    // Obtiene todas las fotos de perfiles de usuarios
    suspend fun getAvatars(): MutableList<String> {
        val avatars = mutableListOf<String>()
        try {
            val result = firebaseStorage.reference.child("avatarUsers").listAll().await()

            result.items.forEach { file ->
                val url = file.downloadUrl.await()
                avatars.add(url.toString())

            }
        } catch (e: Exception) {
            println("Error al obtener photos : ${e.message}")
        }
        return avatars
    }


    suspend fun getLastId(): Long {
        val result = firebaseFirestore.collection("usuarios").orderBy("id").limit(1).get()
            .await() // ordenar descendentemente

        return if (result.documents.isEmpty()) {
            0
        } else {
            result.documents.first().getLong("id")!!
        }
    }


}