package com.example.listapp.viewmodles

import android.app.AlertDialog
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.listapp.R
import com.example.listapp.data.DataRepository
import com.example.listapp.data.Note
import com.example.listapp.databinding.ActivityMainBinding
import com.example.listapp.databinding.AddNoteDialogBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MainActivityViewModel(private val repository: DataRepository):ViewModel() {
    fun addNote(title:String,date:String,body:String) {
        val newNote = Note(title = title,date =  date, body = body)
        repository.addNoteToDataBase(newNote)
    }
    fun getListOfNotes() = repository.getListOfNotes()

}