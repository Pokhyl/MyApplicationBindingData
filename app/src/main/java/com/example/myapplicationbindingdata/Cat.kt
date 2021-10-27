package com.example.myapplicationbindingdata

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Cat(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    var name:String
)