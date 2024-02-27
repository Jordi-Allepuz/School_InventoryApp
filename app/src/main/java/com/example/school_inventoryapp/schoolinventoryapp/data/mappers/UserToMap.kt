package com.example.school_inventoryapp.schoolinventoryapp.data.mappers

import com.example.school_inventoryapp.schoolinventoryapp.data.dataInfo.User

fun userToMap(user: User): MutableMap<String, Any?> {
    return mutableMapOf(
        "nombre" to user.nombre,
        "email" to user.email,
        "clase" to user.clase
    )
}