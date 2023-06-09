package com.example.utskel4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.utskel4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var myDriver: RecyclerView
    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<Driver>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myDriver = binding.rvDriver
        list.addAll(getListDriver())
        showDriverList()

        //move to results page
        binding.results.setOnClickListener {
            val results = Intent(this@MainActivity, ResultsActivity::class.java)
            startActivity(results)
        }

        //move to teams page
        binding.teams.setOnClickListener {
            val teams = Intent(this@MainActivity, TeamsActivity::class.java)
            startActivity(teams)
        }

    }

    private fun getListDriver(): ArrayList<Driver> {
        val dataFirstName = resources.getStringArray(R.array.data_first_name)
        val dataLastName = resources.getStringArray(R.array.data_last_name)
        val dataPhotoDriver = resources.obtainTypedArray(R.array.data_photo_driver)
        val dataPhotoDriverDetail = resources.obtainTypedArray(R.array.data_photo_driver_detail)
        val dataDriverTeam = resources.getStringArray(R.array.data_driver_team)
        val dataDriverChap = resources.getIntArray(R.array.data_driver_champ)
        val dataDriverPodium = resources.getIntArray(R.array.data_driver_podium)
        val dataDriverCountry = resources.getStringArray(R.array.data_driver_country)
        val dataDriverFlag = resources.obtainTypedArray(R.array.data_driver_flag)
        val dataDriverDesc = resources.getStringArray(R.array.data_driver_desc)

        var listDriver = ArrayList<Driver>()

        for (i in dataFirstName.indices) {
            val driver = Driver(
                dataFirstName[i],
                dataLastName[i],
                dataPhotoDriver.getResourceId(i, -1),
                dataPhotoDriverDetail.getResourceId(i, -1),
                dataDriverTeam[i],
                dataDriverChap[i],
                dataDriverPodium[i],
                dataDriverCountry[i],
                dataDriverFlag.getResourceId(i, -1),
                dataDriverDesc[i]
            )
            listDriver.add(driver)
        }
        return listDriver
    }

    private fun showDriverList() {
        binding.rvDriver.layoutManager = LinearLayoutManager(this)
        val driverAdapter = DriverAdapter(list)
        binding.rvDriver.adapter = driverAdapter
    }
}