package com.example.compose_navigation.constants

sealed class Constants(val route : String){
    object FirstScreen : Constants("Sign_Up")
    object SecondScreen : Constants("Show_Details")

}
