package com.example.listapp.data;


import androidx.lifecycle.LiveData

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch


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
    fun deleteNoteFromDataBase(note: Note){
        GlobalScope.launch {
            noteNoteDao.deleteNote(note)
        }
    }

    fun getListOfNotes() = noteRoomDataSource


}
