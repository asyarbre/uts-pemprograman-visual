package com.example.utskel4

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.utskel4.databinding.ActivityTeamDetailBinding

class TeamDetail : AppCompatActivity() {

    companion object {
        const val EXTRA_TEAM = "extra_team"
    }

    private lateinit var binding: ActivityTeamDetailBinding
    private lateinit var team: Team

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team_detail)

        binding = ActivityTeamDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //back btn
        binding.backTeam.setOnClickListener {
            finish()
        }

        team = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Team>(EXTRA_TEAM, Team::class.java)!!
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Team>(EXTRA_TEAM)!!
        }

        if (team != null) {
            binding.teamName.text = team.nameTeam
            binding.carPhotoDetail.setImageResource(team.photoCar)
            binding.base.text = team.base
            binding.teamChief.text = team.teamChief
            binding.technicalChief.text = team.technicalChief
            binding.teamDesc.text = team.teamDesc
        }
    }
}