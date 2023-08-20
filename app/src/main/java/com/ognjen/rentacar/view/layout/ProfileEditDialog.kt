package com.ognjen.rentacar.view.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.ognjen.rentacar.data.dto.response.UserResponse


@Composable
fun ProfileEditDialog(
    user: UserResponse,
    onConfirm: (UserResponse) -> Unit,
    onDismiss: () -> Unit
) {
    var newProfile by remember { mutableStateOf(user) }

    AlertDialog(
        onDismissRequest = { onDismiss() },
        title = { Text(text = "Edit profile") },
        text = {
            Column {
                ProfileInputField(
                    label = "First name",
                    value = newProfile.firstName,
                    onValueChange = { newFirstName -> newProfile = newProfile.copy(firstName = newFirstName) }
                )
                ProfileInputField(
                    label = "Last name",
                    value = newProfile.lastName,
                    onValueChange = { newLastName -> newProfile = newProfile.copy(lastName = newLastName) }
                )
                ProfileInputField(
                    label = "Phone",
                    value = newProfile.phone,
                    onValueChange = { newPhone -> newProfile = newProfile.copy(phone = newPhone) },
                    keyboardType = KeyboardType.Phone
                )
            }
        },
        confirmButton = {
            Button(onClick = { onConfirm(newProfile) }) {
                Text(text = "Confirm")
            }
        },
        dismissButton = {
            Button(onClick = { onDismiss() }) {
                Text(text = "Cancel")
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileInputField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    keyboardType: KeyboardType = KeyboardType.Text
) {
    Column(
        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
    ) {
        Text(text = label)
        TextField(
            value = value,
            onValueChange = { newValue -> onValueChange(newValue) },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = keyboardType)
        )
    }
}