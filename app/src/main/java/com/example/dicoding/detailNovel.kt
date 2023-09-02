package com.example.dicoding

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Novel(
    val name:String,
    val description:String,
    val photo: Int,
):Parcelable