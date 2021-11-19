package com.ahr.mysimplecleanarchitecture.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ahr.mysimplecleanarchitecture.domain.MessageUseCase

class MainViewModelFactory(private val messageUseCase: MessageUseCase) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> MainViewModel(messageUseCase) as T
            else -> throw IllegalArgumentException("Unknown ViewModel class : ${modelClass.name}")
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: MainViewModelFactory? = null

        fun getInstance(messageUseCase: MessageUseCase): MainViewModelFactory =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: MainViewModelFactory(messageUseCase).apply { INSTANCE = this }
            }
    }
}