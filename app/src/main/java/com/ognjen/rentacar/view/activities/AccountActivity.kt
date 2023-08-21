package com.ognjen.rentacar.view.activities

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ognjen.rentacar.data.dto.response.UserResponse
import com.ognjen.rentacar.view.AppViewModel
import com.ognjen.rentacar.view.layout.Footer
import com.ognjen.rentacar.view.layout.Header
import com.ognjen.rentacar.view.layout.ProfileEditDialog

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountActivity(viewModel: AppViewModel) {

// TODO: Fetch user from api 

//    val user = UserResponse(1, "ogi123", "Ognjen", "Radojcic", "065123123")
    val user = viewModel.userResponse



    Scaffold(topBar = {
        Header()
    }, bottomBar = {
        Footer(viewModel)
    }) { contentPadding ->
        if (user != null) {
            Column(modifier = Modifier.padding(contentPadding)) {
                ProfileCard(userResponse = user)
            }
        } else {
            Text(text = "Loading...")
            LaunchedEffect(true) {
                viewModel.fetchUser()
            }
        }
    }
}


@Composable
fun ProfileCard(userResponse: UserResponse) {
    var isDialogVisible by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Profile",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .align(CenterHorizontally)
                )
                ProfileField(label = "Username", value = userResponse.username)
                ProfileField(label = "First Name", value = userResponse.firstName)
                ProfileField(label = "Last Name", value = userResponse.lastName)
                ProfileField(label = "Phone", value = userResponse.phone)
            }
        }
        Button(onClick = { isDialogVisible = true }) {
            Text(text = "Edit", fontSize = 25.sp)
        }
        if (isDialogVisible) {
            ProfileEditDialog(
                user = userResponse,
                onConfirm = { updatedUser ->
                    isDialogVisible = false
                },
                onDismiss = {
                    isDialogVisible = false
                }
            )
        }
    }
}

@Composable
fun ProfileField(label: String, value: String) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = label,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = value,
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 4.dp)
        )
    }
}

@Preview
@Composable
fun AccountPreview() {
    AccountActivity(viewModel = AppViewModel())
}