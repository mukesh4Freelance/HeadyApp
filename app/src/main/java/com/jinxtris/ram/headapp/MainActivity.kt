package com.jinxtris.ram.headapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.jinxtris.ram.headapp.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeResources()
    }

    private fun initializeResources() {
        mainViewModel = ViewModelProviders.of(this)[MainViewModel::class.java]
        mainViewModel.callService()
    }


}
