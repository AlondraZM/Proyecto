package com.example.proyecto.database

class Product (
    ID: String,
    Nombre: String,
    Descripcion: String,
    Precio: String,
    Calificacion: String
) {
    val ID:String = ID
    val Nombre:String = Nombre
    val Descripcion:String = Descripcion
    val Precio:String = Precio
    val Calificacion: String = Calificacion

}

fun Product.toEntity() = ProductEntity(
    ID,
    Nombre,
    Descripcion,
    Precio,
    Calificacion

)