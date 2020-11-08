package com.example.listapp.util

import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.listapp.data.Note

class NoteRecyclerAdapter():ListAdapter<Note,NoteRecyclerAdapter.NoteViewHolder>(NoteListDiffUtilCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteRecyclerAdapter.NoteViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: NoteRecyclerAdapter.NoteViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    class NoteViewHolder(view: View):RecyclerView.ViewHolder(view){

    }
}

