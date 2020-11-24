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
    fun upSertNote(note: Note) {
        repository.addNoteToDataBase(note)
    }
    fun getListOfNotes() = repository.getListOfNotes()

    fun deleteNote(note: Note) {
        repository.deleteNoteFromDataBase(note)
    }
    fun createNote( title:String,date:String, body:String):Note{
        return Note(title = title,date =  date, body = body)
    }

    fun updateNote(note: Note,context: Context) {
        val mDialogView = AddNoteDialogBinding.inflate(LayoutInflater.from(context))
        mDialogView.apply {
            dialogTitle.setText(note.title)
            dialogDate.setText(note.date)
            dialogBody.setText(note.body)

        }
        MaterialAlertDialogBuilder(context)
            .setView(mDialogView.root)
            .setTitle("UPDATE NOTE")
            .setPositiveButton("ok") { dialog, which ->
                note.title = mDialogView.dialogTitle.text.toString()
                note.date = mDialogView.dialogDate.text.toString()
                note.body = mDialogView.dialogBody.text.toString()
                upSertNote(note)
                dialog.cancel()
            }.show()
    }

}