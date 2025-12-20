package com.example.testowanie4.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PersonDao {

    @Insert
    suspend fun insert(person: Person)

    @Query("SELECT * FROM persons")
    fun getAll(): Flow<List<Person>>

    @Delete
    suspend fun delete(person: Person)
}