package com.example.school_inventoryapp.schoolinventoryapp.data.mappers

import com.example.school_inventoryapp.schoolinventoryapp.data.dataInfo.Material

fun materialToMap(material: Material): MutableMap<String, Any?> {
    return mutableMapOf(
        "nombre" to material.nombre,
        "cantidad" to material.cantidad,
        "curso" to material.curso,
        "asignatura" to material.asignatura,
        "description" to material.description,
        "image" to material.image
    )
}