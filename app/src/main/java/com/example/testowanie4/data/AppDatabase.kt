package com.example.testowanie4.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Person::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun personDao(): PersonDao
}