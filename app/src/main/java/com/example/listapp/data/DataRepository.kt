package com.example.listapp.data;

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.sql.CommonDataSource

class DataRepository(
    private val noteNoteDao: NoteDao
    //Get firestore..
) {
    private val noteRoomDataSource:LiveData<List<Note>> = noteNoteDao.getAllNotes()

    //Could contain comparing and structuring logic from different data resources.

   fun addNoteToDataBase( note:Note) {
       GlobalScope.launch{
           noteNoteDao.addNote(note)
       }
    }

    fun getListOfNotes() = noteRoomDataSource


}
