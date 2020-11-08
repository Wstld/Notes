package com.example.listapp.util

import androidx.recyclerview.widget.DiffUtil
import com.example.listapp.data.Note

class NoteListDiffUtilCallback() : DiffUtil.ItemCallback<Note>() {
    override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
        TODO("Not yet implemented")
    }

    override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
        TODO("Not yet implemented")
    }

}
