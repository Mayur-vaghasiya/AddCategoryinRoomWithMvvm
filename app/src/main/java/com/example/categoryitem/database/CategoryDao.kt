package com.example.categoryitem.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.categoryitem.model.CategoryModel

@Dao
interface CategoryDao {


    @Query("SELECT * FROM Category ")
    fun getAllCategoryInfo(): ArrayList<CategoryModel>?


    @Insert
    fun insertCategory(user: CategoryModel?)
}