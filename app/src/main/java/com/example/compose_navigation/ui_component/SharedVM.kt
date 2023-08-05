package com.example.compose_navigation.ui_component

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.compose_navigation.constants.Profile



class SharedVM : ViewModel() {
     var profile by mutableStateOf<Profile?>(null)
         private set

    fun setProfileDetails(newProfile: Profile){
        profile = newProfile
    }


}