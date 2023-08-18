package com.ognjen.rentacar.activities

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
import com.ognjen.rentacar.AppViewModel
import com.ognjen.rentacar.layout.Header


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginActivity(viewModel: AppViewModel) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showError by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            Header()
        },
        content = { contentPadding ->
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
                    label = { Text("Username") },
                    modifier = Modifier.fillMaxWidth(),
                )
                TextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Password") },
                    modifier = Modifier.fillMaxWidth(),
                )
                Button(onClick = {
                    if (loginFormCheck(username, password)) {
                        viewModel.login()
                    } else {
                        showError = true
                    }

                }) {
                    Text(text = "Login")
                }
                Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    Text(text = "Nemate profil?")
                    Text(
                        text = "Registracija",
                        modifier = Modifier.clickable { viewModel.navigateToRegister() },
                        textDecoration = TextDecoration.Underline,
                        color = Color.Blue
                    )
                }

                if (showError) {
                    Text(text = "Netacni podaci za logovanje", color = MaterialTheme.colorScheme.error)
                }
            }
        },
    )
}

fun loginFormCheck(username: String, password: String): Boolean {
    return username == "ogi" && password == "ogi"
}