package com.example.school_inventoryapp.schoolinventoryapp.data.sources.remote

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.tasks.await
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject



class AuthService @Inject constructor(private val firebaseAuth: FirebaseAuth){

    // Función suspendida para iniciar sesión con correo electrónico y contraseña.
    // Retorna el usuario de Firebase si la autenticación es exitosa, de lo contrario null.
    suspend fun login (email:String, password:String): FirebaseUser? {
        return firebaseAuth.signInWithEmailAndPassword(email, password).await().user
    }

    // Función suspendida para registrar un nuevo usuario con correo electrónico y contraseña.
    // Retorna el usuario de Firebase si el registro es exitoso, de lo contrario null.
    suspend  fun signUp(email: String, password: String): FirebaseUser? {
        return firebaseAuth.createUserWithEmailAndPassword(email, password).await().user
    }

    // Función para cerrar la sesión del usuario actual.
    fun logOut(){
        return firebaseAuth.signOut()
    }


    // Función para obtener el usuario actualmente logueado.
    // Retorna el usuario de Firebase si hay uno logueado, de lo contrario null.
    fun getCurrentUser() = firebaseAuth.currentUser


    // Función para verificar si hay un usuario actualmente logueado.
    // Retorna true si hay un usuario logueado, de lo contrario false.
    fun isUserLogged():Boolean{
        return getCurrentUser() != null
    }

    // sacar la fecha de creacion del usuario
    fun getCreationDate():String? {
        val timestamp = firebaseAuth.currentUser?.metadata?.lastSignInTimestamp ?: return null
        val date = Date(timestamp)
        val format = SimpleDateFormat("MMMM,yyyy", Locale.getDefault())
        return format.format(date)
    }


}