package com.example.compose_navigation.ui_component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import com.example.compose_navigation.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowDetails(navController: NavHostController, sharedVM: SharedVM) {
    val profile = sharedVM.profile

    Box(modifier = Modifier.fillMaxSize()) {

        TopAppBar(
            title = { Text(text = "Profile Details") },
            colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Gray),

            navigationIcon = {
                IconButton(onClick = {
                    val navOptions =
                        NavOptions.Builder().setPopUpTo("Sign_Up", inclusive = true).build()
                    navController.navigate("Sign_Up", navOptions)

                }) {

                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Close")
                }
            }
        )

        Card(
            modifier = Modifier
                .padding(all = 2.dp)
                .padding(top = 70.dp)
                .fillMaxWidth()

        ) {


            Row() {
                Image(
                    painter = painterResource(id = R.drawable.user), contentDescription = "",
                    Modifier
                        .padding(56.dp)
                        .clip(CircleShape)
                        .height(60.dp)
                )
                Column(modifier = Modifier.padding(all = 10.dp)) {

                    Text(
                        text = "${profile?.firstName} ${profile?.lastName}",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.W600,
                        modifier = Modifier.padding(6.dp)
                    )

                    profile?.emailAddress?.let {
                        Text(
                            text = it,
                            fontSize = 25.sp,
                            fontWeight = FontWeight.W600,
                            modifier = Modifier.padding(6.dp)
                        )
                    }

                    Text(
                        text = "age: ${profile?.age}",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.W600,
                        modifier = Modifier.padding(6.dp)
                    )

                }

            }

        }
    }

}