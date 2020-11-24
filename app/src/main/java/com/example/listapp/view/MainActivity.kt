package com.example.listapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listapp.R
import com.example.listapp.data.DataRepository
import com.example.listapp.data.Note
import com.example.listapp.databinding.ActivityMainBinding
import com.example.listapp.databinding.AddNoteDialogBinding
import com.example.listapp.util.InjectorUtil
import com.example.listapp.util.NoteRecyclerAdapter
import com.example.listapp.viewmodles.MainActivityViewModel
import com.example.listapp.viewmodles.MainAcvtivityViewModelFactory
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainActivityViewModel
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val factory = InjectorUtil.getViewModelFactory(application)
        viewModel = ViewModelProvider(this,factory).get(
            MainActivityViewModel::class.java
        )

        initRecyclerView()

        binding.materialButton.setOnClickListener {
            val mDialogView = AddNoteDialogBinding.inflate(layoutInflater)
            MaterialAlertDialogBuilder(this)
                    .setView(mDialogView.root)
                    .setTitle("ADD NOTE")
                    .setPositiveButton("ok") { dialog, which ->
                        val title = mDialogView.dialogTitle.text.toString()
                        val date = mDialogView.dialogDate.text.toString()
                        val body = mDialogView.dialogBody.text.toString()

                        viewModel.addNote(title, date, body)

                        dialog.cancel()
                    }.show()
        }

    }



    fun initRecyclerView(){
        val noteList = viewModel.getListOfNotes()
        val recyclerAdapter = NoteRecyclerAdapter { Note -> viewModel.deleteNote(Note) }
        binding.recyclerView.apply {
            val layoutManager = LinearLayoutManager(this@MainActivity)
            setLayoutManager(layoutManager)
            layoutManager.reverseLayout = true
            adapter = recyclerAdapter
        }
        noteList.observe(this,{
            recyclerAdapter.submitList(noteList.value!!.toList())
            binding.recyclerView.smoothScrollToPosition(noteList!!.value!!.size - 1)
        })
    }
}