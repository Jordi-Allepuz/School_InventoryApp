package com.example.school_inventoryapp.schoolinventoryapp.data.sources.remote

import com.example.school_inventoryapp.schoolinventoryapp.data.dataInfo.Material
import com.example.school_inventoryapp.schoolinventoryapp.data.dataInfo.User
import com.example.school_inventoryapp.schoolinventoryapp.data.mappers.materialToMap
import com.example.school_inventoryapp.schoolinventoryapp.data.mappers.userToMap
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class StorageService @Inject constructor(
    private val firebaseStorage: FirebaseStorage,
    private val firebaseFirestore: FirebaseFirestore
) {


    // Registra los datos de un usuario en Firestore
    suspend fun createNewUser(user: User): Boolean {
        val usuarioMap = userToMap(user)
        return firebaseFirestore.collection("usuarios").add(usuarioMap).isComplete
    }

    suspend fun editUser(user: User, email: String): Boolean {
        val userMap = userToMap(user)
       return firebaseFirestore.collection("usuarios").whereEqualTo("email", email).get().await().documents.first().reference.set(userMap).isComplete
    }

    suspend fun editMaterial(material: Material, nombre: String): Boolean {
        val materialMap = materialToMap(material)
        return firebaseFirestore.collection("materiales").whereEqualTo("nombre", nombre).get().await().documents.first().reference.set(materialMap).isComplete
    }

    // Obtiene la información de un usuario por su email y retorna un objeto User
    suspend fun getInfoUser(email: String): User? {
        val result =
            firebaseFirestore.collection("usuarios").whereEqualTo("email", email).get().await()
        return result.documents.firstOrNull()?.toObject<User>()
    }

    // Obtiene el ID de un usuario por su email
    suspend fun getUserId(email: String): String? {
        val result =
            firebaseFirestore.collection("usuarios").whereEqualTo("email", email).get().await()
        return result.documents.firstOrNull()?.id
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


    // Añade un nuevo material a la colección de materiales
    suspend fun addMaterial(material: Material): Boolean {
        val materialMap = materialToMap(material)
        return firebaseFirestore.collection("materiales").add(materialMap).isComplete
    }


    // Obtiene la información de un libro por su nombre y retorna un objeto Book
    suspend fun getMaterialInfo(name: String): Material? {
        val result =
            firebaseFirestore.collection("materiales").whereEqualTo("nombre", name).get().await()
        return result.documents.firstOrNull()?.toObject<Material>()
    }



    // Obtiene todos los materiales disponibles y retorna una lista mutable de objetos Material.
    suspend fun getMaterialsList(): MutableList<Material> {
        val materiales = mutableListOf<Material>()
        try {
            val result = firebaseFirestore
                .collection("materiales")
                .get()
                .await()

            for (documento in result) {
                val material = documento.toObject(Material::class.java)
                materiales.add(material)
            }
        } catch (e: Exception) {
            println("Error al obtener materiales coleccion: ${e.message}")
        }
        return materiales

    }

    //obtener materiales filtrados por asignatura
    suspend fun getMaterialsBySubject(subject: String): MutableList<Material> {
        val materiales = mutableListOf<Material>()
        try {
            val result = firebaseFirestore
                .collection("materiales")
                .whereEqualTo("asignatura", subject)
                .get()
                .await()

            for (documento in result) {
                val material = documento.toObject(Material::class.java)
                materiales.add(material)
            }
        } catch (e: Exception) {
            println("Error al obtener materiales coleccion: ${e.message}")
        }
        return materiales
    }





}