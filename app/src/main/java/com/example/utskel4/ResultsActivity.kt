package com.example.utskel4

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.utskel4.databinding.ActivityResultsBinding

class ResultsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)

        binding = ActivityResultsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //back btn
        binding.resultBack.setOnClickListener {
            finish()
        }
    }
}