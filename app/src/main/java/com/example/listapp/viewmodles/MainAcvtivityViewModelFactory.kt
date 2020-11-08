package com.example.listapp.viewmodles

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.listapp.data.DataRepository

class MainAcvtivityViewModelFactory(private val dataRepository: DataRepository):ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainActivityViewModel(dataRepository) as T
    }
}