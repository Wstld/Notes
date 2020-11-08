package com.example.listapp.util

import com.example.listapp.data.DataRepository
import com.example.listapp.viewmodles.MainAcvtivityViewModelFactory

object InjectorUtil {
    fun getViewModelFactory():MainAcvtivityViewModelFactory{
        val repository = DataRepository()
        return MainAcvtivityViewModelFactory(repository)
    }
}