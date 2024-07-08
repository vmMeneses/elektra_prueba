package com.meneses.appproductelekra.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.meneses.appproductelekra.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()
    }

    private fun initUI() {
        initObserver()
        initUIState()
    }

    private fun initUIState() {

    }

    private fun initObserver() {

    }
}