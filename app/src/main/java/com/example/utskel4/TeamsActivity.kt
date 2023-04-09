package com.example.utskel4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.utskel4.databinding.ActivityTeamsBinding

class TeamsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTeamsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teams)

        binding = ActivityTeamsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //back btn
        binding.teamsBack.setOnClickListener {
            finish()
        }
    }
}