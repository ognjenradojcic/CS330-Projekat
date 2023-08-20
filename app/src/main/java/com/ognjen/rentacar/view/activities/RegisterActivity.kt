package com.ognjen.rentacar.view.activities

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ognjen.rentacar.view.AppViewModel
import com.ognjen.rentacar.view.layout.Header

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterActivity(viewModel: AppViewModel) {

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var showError by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            Header()
        },
    ) { contentPadding ->
        Column(
            modifier = Modifier.padding(
                top = contentPadding.calculateTopPadding() + 20.dp,
                end = 20.dp,
                start = 20.dp,
                bottom = contentPadding.calculateBottomPadding()
            ),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            TextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("Username", fontSize = 20.sp) },
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password", fontSize = 20.sp) },
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = firstName,
                onValueChange = { firstName = it },
                label = { Text("First name", fontSize = 20.sp) },
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = lastName,
                onValueChange = { lastName = it },
                label = { Text("Last name", fontSize = 20.sp) },
                modifier = Modifier.fillMaxWidth()
            )

            TextField(
                value = phone,
                onValueChange = { phone = it },
                label = { Text("Phone", fontSize = 20.sp) },
                modifier = Modifier.fillMaxWidth()
            )

            Button(onClick = {
                if (registerFormCheck(username, password, firstName, lastName, phone)) {
                    viewModel.register()
                } else {
                    showError = true
                }
            }) {
                Text(text = "Register")
            }
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                Text(text = "Already have account?")
                Text(
                    text = "Login",
                    modifier = Modifier.clickable { viewModel.navigateToLogin() },
                    textDecoration = TextDecoration.Underline,
                    color = Color.Blue
                )
            }
            if (showError) {
                Text(text = "Incorrect credentials", color = MaterialTheme.colorScheme.error)
            }
        }
    }
}

fun registerFormCheck(
    username: String,
    password: String,
    firstName: String,
    lastName: String,
    phone: String
): Boolean {
    return username == "ogi" && password == "ogi" && firstName == "Ognjen"
            && lastName == "Radojcic" && phone == "123"
}