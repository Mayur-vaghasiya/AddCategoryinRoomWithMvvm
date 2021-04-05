package com.example.categoryitem.model

import androidx.room.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Entity(tableName = "Category")
data class CategoryModel(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "CategoryId")
    val categoryId: Int=0,
    @ColumnInfo(name = "CategoryName")
    val categoryName:String,
    @ColumnInfo(name = "Item")
    val categoryItem:ArrayList<ItemModel>
)

class ItemsTypeConverter {

    @TypeConverter
    fun listToJson(value: ArrayList<ItemModel>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String) = Gson().fromJson(value, Array<ItemModel>::class.java).toList()
}