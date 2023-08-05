package com.example.compose_navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.compose_navigation.constants.Constants
import com.example.compose_navigation.ui_component.SharedVM
import com.example.compose_navigation.ui_component.ShowDetails
import com.example.compose_navigation.ui_component.SignUp

@Composable
fun setUpNavGraph(navHostController: NavHostController){
    val sharedVM: SharedVM = viewModel()
    NavHost(navController = navHostController, startDestination = Constants.FirstScreen.route ){
        composable(route = Constants.FirstScreen.route){
            SignUp(navController = navHostController,sharedVM)
        }
        composable(route = Constants.SecondScreen.route){
            ShowDetails(navController = navHostController,sharedVM)
        }
    }

}