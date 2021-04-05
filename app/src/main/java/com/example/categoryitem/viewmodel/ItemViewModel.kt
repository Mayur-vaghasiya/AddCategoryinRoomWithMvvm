package com.example.categoryitem.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.categoryitem.model.ItemModel

class ItemViewModel:ViewModel() {
    var lst = MutableLiveData<ArrayList<ItemModel>>()
    var newlist = arrayListOf<ItemModel>()

    fun add(item: ItemModel){
        newlist.add(item)
        lst.value=newlist
    }
}