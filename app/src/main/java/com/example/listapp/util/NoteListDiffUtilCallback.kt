package com.example.listapp.util

import androidx.recyclerview.widget.DiffUtil
import com.example.listapp.data.Note

class NoteListDiffUtilCallback() : DiffUtil.ItemCallback<Note>() {
    override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
     return  oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
     return  oldItem.body == newItem.body && oldItem.title == newItem.title && oldItem.date == newItem.date
    }

}
