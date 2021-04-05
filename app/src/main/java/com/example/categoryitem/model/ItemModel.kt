package com.example.categoryitem.model

import androidx.room.ColumnInfo

data class ItemModel (
    @ColumnInfo(name = "ItemName")
    var Item :String
)