package com.example.object_oriented_pj_10.EXERCISE

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ExerciseList(
    val name: String,
    val restTime: Int,
    val exerciseTime: Int,
) : Parcelable