package com.example.utskel4

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.utskel4.databinding.ActivityDriverBinding

class DriverDetail : AppCompatActivity() {
    companion object {
        const val EXTRA_DRIVER = "extra_driver"
    }

    private lateinit var binding: ActivityDriverBinding
    private lateinit var driver: Driver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_driver)

        binding = ActivityDriverBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backBtn.setOnClickListener {
            finish()
        }

        driver = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Driver>(EXTRA_DRIVER, Driver::class.java)!!
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Driver>(EXTRA_DRIVER)!!
        }

        if (driver != null) {
            binding.driverFirstName.text = driver.firstName
            binding.driverLastName.text = driver.lastName
            binding.driverTeam.text = driver.driverTeam
            binding.driverPhotoDetail.setImageResource(driver.driverPhotoDetail)
            binding.driverChamp.text = driver.driverChamp.toString()
            binding.driverPodium.text = driver.driverPodium.toString()
            binding.driverDesc.text = driver.driverDesc

            binding.shareBtn.setOnClickListener {
                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/plain"
                intent.putExtra(
                    Intent.EXTRA_TEXT, """
                    Hi! kamu akan membagikan informasi seputar driver ${driver.firstName} ${driver.lastName}, yang berasal dari team ${driver.driverTeam}
                """.trimIndent()
                )
                startActivity(Intent.createChooser(intent, "Bagikan Ke :"))
            }
        }
    }


}