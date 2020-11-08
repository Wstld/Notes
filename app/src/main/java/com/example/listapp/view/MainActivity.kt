package com.example.listapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.listapp.R
import com.example.listapp.data.DataRepository
import com.example.listapp.databinding.ActivityMainBinding
import com.example.listapp.viewmodles.MainActivityViewModel
import com.example.listapp.viewmodles.MainAcvtivityViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainActivityViewModel
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repo = DataRepository()
        val factory = MainAcvtivityViewModelFactory(repo)
        viewModel = ViewModelProvider(this,factory).get(
            MainActivityViewModel::class.java
        )



        binding.materialButton.setOnClickListener {
            viewModel.test(this)
        }



    }
}