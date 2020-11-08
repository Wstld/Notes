package com.example.listapp.viewmodles

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.listapp.data.DataRepository

class MainActivityViewModel(private val repository: DataRepository):ViewModel() {
    fun test(context:Context){
        Toast.makeText(context, "lägger till en lapp", Toast.LENGTH_SHORT).show()
    }
}