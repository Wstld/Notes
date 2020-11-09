package com.example.listapp.data

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addNote(note: Note)

    @Delete
    fun deleteNote(note:Note)

    @Query("SELECT * FROM notes ORDER BY date")
    fun getAllNotes(): LiveData<List<Note>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(data: List<Note>)
}