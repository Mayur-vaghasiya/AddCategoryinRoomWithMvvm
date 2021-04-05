package com.example.categoryitem.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.categoryitem.model.CategoryModel

@Database(entities = arrayOf(CategoryModel::class), version = 1, exportSchema = false)
@TypeConverters(ItemConverters::class)
abstract class CategoryDatabase: RoomDatabase() {

    abstract fun categoryDao() : CategoryDao

    companion object {

        @Volatile
        private var INSTANCE: CategoryDatabase? = null

        fun getCategoryDatabase(context: Context) : CategoryDatabase?{

            if (INSTANCE != null) return INSTANCE!!

            synchronized(this) {

                INSTANCE = Room
                    .databaseBuilder(context, CategoryDatabase::class.java, "Category_DATABASE")
                    .fallbackToDestructiveMigration()
                    .build()

                return INSTANCE!!

            }
        }

    }

}