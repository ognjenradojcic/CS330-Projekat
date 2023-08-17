package com.ognjen.rentacar.activities

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.ognjen.rentacar.AppViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterActivity(viewModel: AppViewModel, paddingValues: PaddingValues) {

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("MetShop") })
        },
    ) { contentPadding ->
        Column(modifier = Modifier.padding(contentPadding)) {
            TextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("Username") }
            )
            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") }
            )
            TextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("Username") }
            )
            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") }
            )




            Button(onClick = {
                viewModel.login()
            }) {
                Text(text = "Register")
            }
            Row {
                Text(text = "Vec imate profil?")
                Text(
                    text = "Login",
                    modifier = Modifier.clickable { viewModel.navigateToRegister() })
            }
        }
    }

}