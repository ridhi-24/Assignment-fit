package com.example.assignment.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.assignment.databinding.DetailScreenBinding

class Detailactivity :AppCompatActivity(){
    lateinit var binding: DetailScreenBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DetailScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    }