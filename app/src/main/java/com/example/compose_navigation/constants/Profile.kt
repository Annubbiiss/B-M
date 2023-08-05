package com.example.compose_navigation.constants

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Profile(
    val firstName:String,
    val lastName:String,
    val emailAddress:String,
    val age: String,

    ) : Parcelable
