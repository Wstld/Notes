package com.example.listapp.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.listapp.R
import com.example.listapp.data.Note
import com.example.listapp.databinding.NoteItemLayoutBinding

class NoteRecyclerAdapter(val onTrashClick:(Note) -> Unit,val onItemClick: (Note) -> Unit):ListAdapter<Note,NoteRecyclerAdapter.NoteViewHolder>(NoteListDiffUtilCallback(),) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):NoteViewHolder {
        val itemBindning = NoteItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return NoteViewHolder(itemBindning)

    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        getItem(position).let { note ->
            holder.title.text = note.title
            holder.body.text = note.body
            holder.date.text = note.date
            holder.itemView.setOnClickListener {
                onItemClick(note)
            }
            holder.trasBtn.setOnClickListener {
                onTrashClick(note)
            }
        }
    }



    class NoteViewHolder(itemBinding:NoteItemLayoutBinding):RecyclerView.ViewHolder(itemBinding.root){
        var title = itemBinding.noteHeadline
        var body = itemBinding.noteBody
        var date = itemBinding.noteDate
        val trasBtn = itemBinding.trashBtn
    }
}

