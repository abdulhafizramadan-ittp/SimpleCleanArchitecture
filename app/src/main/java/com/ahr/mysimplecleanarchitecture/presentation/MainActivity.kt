package com.ahr.mysimplecleanarchitecture.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.ahr.mysimplecleanarchitecture.databinding.ActivityMainBinding
import com.ahr.mysimplecleanarchitecture.di.Injection

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModelFactory = MainViewModelFactory(Injection.provideMessageUseCase())
        val mainViewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]

        mainViewModel.setName("Dicoding")
        mainViewModel.message.observe(this) { messageEntity ->
            if (messageEntity != null) {
                binding.tvWelcome.text = messageEntity.welcomeMessage
            }
        }
    }
}