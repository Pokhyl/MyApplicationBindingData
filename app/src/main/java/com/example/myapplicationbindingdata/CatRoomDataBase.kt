package com.example.myapplicationbindingdata

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Cat::class],version = 1, exportSchema = false)
abstract class CatRoomDataBase: RoomDatabase() {

    abstract fun f1(): CatDao

    companion object {
        @Volatile
        private var INSTANCE: CatRoomDataBase? = null

        fun getDatabase(context: Context): CatRoomDataBase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CatRoomDataBase::class.java,
                    "cat_database"
                )
                    // Wipes and rebuilds instead of migrating if no Migration object.
                    // Migration is not part of this codelab.
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}