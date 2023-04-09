package com.example.utskel4

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Team(
    val nameTeam: String,
    val photoCar: Int,
    val base: String,
    val teamChief: String,
    val technicalChief: String,
    val teamDesc: String
) : Parcelable
