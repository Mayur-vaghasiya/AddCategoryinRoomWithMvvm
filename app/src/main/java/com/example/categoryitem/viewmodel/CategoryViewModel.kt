package com.example.categoryitem.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.categoryitem.database.CategoryDatabase
import com.example.categoryitem.model.CategoryModel

 public class CategoryViewModel(app: Application): AndroidViewModel(app) {

    lateinit var allUsers : MutableLiveData<ArrayList<CategoryModel>>

    init{
        allUsers = MutableLiveData()
        getAllUsers()
    }

    fun getAllCategoryObservers(): MutableLiveData<ArrayList<CategoryModel>> {
        return allUsers
    }

    fun getAllUsers() {
        val categoryDao=CategoryDatabase.getCategoryDatabase(getApplication())?.categoryDao()
        val list = categoryDao?.getAllCategoryInfo()

        allUsers.postValue(list)
    }

    fun insertUserInfo(entity: CategoryModel){
        val categoryDao=CategoryDatabase.getCategoryDatabase(getApplication())?.categoryDao()
        categoryDao?.insertCategory(entity)
        getAllUsers()
    }
}