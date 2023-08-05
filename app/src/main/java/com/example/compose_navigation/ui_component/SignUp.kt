package com.example.compose_navigation.ui_component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.compose_navigation.constants.Constants
import com.example.compose_navigation.constants.Profile
import com.example.compose_navigation.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUp(
    navController: NavHostController,
    sharedVM: SharedVM
) {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Image(
            painter = painterResource(id = R.drawable.img), contentDescription = "",
            Modifier
                .padding(56.dp)
                .clip(CircleShape)
                .size(120.dp)
        )


        OutlinedTextField(
            value = firstName,
            onValueChange = { firstName = it },
            label = { Text("First Name") }
        )
        Spacer(modifier = Modifier.height(30.dp))

        OutlinedTextField(
            value = lastName,
            onValueChange = { lastName = it },
            label = { Text("Last Name:") }
        )
        Spacer(modifier = Modifier.height(30.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email:") }
        )
        Spacer(modifier = Modifier.height(30.dp))

        OutlinedTextField(
            value = age,
            onValueChange = { age = it },
            label = { Text("Age:") }
        )
        Spacer(modifier = Modifier.height(50.dp))


        Button(onClick = { if (firstName.isNotEmpty()&&lastName.isNotEmpty()&&email.isNotEmpty()&&age.isNotEmpty()) {
            val profile = Profile(firstName, lastName, email, age,)
            sharedVM.setProfileDetails(profile)
            navController.navigate(Constants.SecondScreen.route)
        }

        }
        ) {
            Modifier.padding(15.dp)

            Text(text = "Confirm")
        }

    }
}




