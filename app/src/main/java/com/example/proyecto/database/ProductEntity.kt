package com.example.proyecto.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = TABLE_PRODUCTS)
data class ProductEntity(
    @ColumnInfo(name = "ID") @PrimaryKey val uuid: String,
    @ColumnInfo(name = "Nombre") val name:String,
    val Descripcion: String,
    val Precio: String,
    val Calificacion: String
)

fun ProductEntity.toProduct() = Product(uuid, name, Descripcion, Precio, Calificacion)
