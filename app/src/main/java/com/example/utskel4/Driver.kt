package com.example.utskel4

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Driver(
    val firstName: String,
    val lastName: String,
    val driverPhoto: Int
) : Parcelable
