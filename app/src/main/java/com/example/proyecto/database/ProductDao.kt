package com.example.proyecto.database

import androidx.room.*

@Dao
interface ProductDao {
    @Query("SELECT * FROM $TABLE_PRODUCTS")
    fun getProductsFromDatabase(): List<ProductEntity>

    @Query("SELECT * FROM $TABLE_PRODUCTS WHERE ID = :uuid")
    fun getProductsByUuid(uuid: String): ProductEntity

    @Delete
    fun delete(product: ProductEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(product: ProductEntity)

}