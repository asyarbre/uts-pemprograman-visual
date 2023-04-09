package com.example.utskel4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.utskel4.databinding.ActivityTeamsBinding

class TeamsActivity : AppCompatActivity() {
    private lateinit var myTeam: RecyclerView
    private lateinit var binding: ActivityTeamsBinding
    private val list = ArrayList<Team>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teams)

        binding = ActivityTeamsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myTeam = binding.rvTeams
        list.addAll(getListTeam())
        showTeamList()

        //back btn
        binding.teamsBack.setOnClickListener {
            finish()
        }
    }

    private fun getListTeam(): ArrayList<Team> {
        val dataTeamName = resources.getStringArray(R.array.data_team_name)
        val dataPhotoCar = resources.obtainTypedArray(R.array.data_team_car)
        val dataBase = resources.getStringArray(R.array.data_team_base)
        val dataTeamChief = resources.getStringArray(R.array.data_team_chief)
        val dataTechnicalChief = resources.getStringArray(R.array.data_team_technical)
        val dataDesc = resources.getStringArray(R.array.data_team_desc)

        val listTeam = ArrayList<Team>()

        for (i in dataTeamName.indices) {
            val team = Team(
                dataTeamName[i],
                dataPhotoCar.getResourceId(i, -1),
                dataBase[i],
                dataTeamChief[i],
                dataTechnicalChief[i],
                dataDesc[i]
            )
            listTeam.add(team)
        }
        return listTeam
    }

    private fun showTeamList() {
        binding.rvTeams.layoutManager = LinearLayoutManager(this)
        val teamAdapter = TeamAdapter(list)
        binding.rvTeams.adapter = teamAdapter
    }
}