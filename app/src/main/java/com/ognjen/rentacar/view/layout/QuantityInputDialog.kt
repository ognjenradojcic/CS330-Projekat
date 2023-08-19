package com.ognjen.rentacar.view.layout

import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuantityInputDialog(
    onConfirm: (String, Int) -> Unit,
    onDismiss: () -> Unit
) {
    var quantity by remember { mutableStateOf(1) }
    var address by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = { onDismiss() },
        title = { Text(text = "Order") },
        text = {
            Column {
                Column {
                    Text(text = "Address", fontSize = 20.sp)
                    TextField(
                        value = address.toString(),
                        onValueChange = { newValue ->
                            address = newValue
                        },
                    )
                }
                Column {
                    Text(text = "Quantity", fontSize = 20.sp)
                    TextField(
                        value = quantity.toString(),
                        onValueChange = { newValue ->
                            quantity = newValue.toIntOrNull() ?: 0
                        },
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Number
                        )

                    )
                }
            }
        },
        confirmButton = {
            Button(onClick = { onConfirm(address, quantity) }) {
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