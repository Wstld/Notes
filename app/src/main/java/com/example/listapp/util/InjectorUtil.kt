package com.example.listapp.util

import android.app.Application
import com.example.listapp.data.DataRepository
import com.example.listapp.data.RoomNoteDatabase
import com.example.listapp.viewmodles.MainAcvtivityViewModelFactory

object InjectorUtil {
    fun getViewModelFactory(application: Application):MainAcvtivityViewModelFactory{
        val roomDao = RoomNoteDatabase.getInstance(application).noteDao()
        val repository = DataRepository(roomDao)
        return MainAcvtivityViewModelFactory(repository)
    }
}