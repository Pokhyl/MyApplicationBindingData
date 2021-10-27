package com.example.myapplicationbindingdata

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface CatDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(cat: Cat)
}