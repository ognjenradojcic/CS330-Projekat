package com.ognjen.rentacar.view.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ognjen.rentacar.view.AppViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Header() {
    TopAppBar(
        title = {
            Text(
                "MetShop",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colorScheme.onPrimary,
                fontSize = 30.sp
            )
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary)
    )
}

@Composable
fun Footer(viewModel: AppViewModel) {
    BottomAppBar(containerColor = MaterialTheme.colorScheme.primaryContainer) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.clickable { viewModel.navigateToHome() }
            ) {
                Icon(
                    Icons.Default.Home,
                    contentDescription = "Home",
                    Modifier.size(50.dp)
                )
                Text(text = "Home")
            }

            Spacer(
                modifier = Modifier
                    .fillMaxHeight()
                    .size(1.dp)
                    .background(Color.Black)

            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.clickable { viewModel.navigateToOrders() }
            ) {
                Icon(
                    Icons.Default.ShoppingCart,
                    contentDescription = "Orders",
                    Modifier.size(50.dp)
                )
                Text(text = "Orders")
            }

            Spacer(
                modifier = Modifier
                    .fillMaxHeight()
                    .size(1.dp)
                    .background(Color.Black)

            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.clickable { viewModel.navigateToAccount() }
            ) {
                Icon(
                    Icons.Default.AccountCircle,
                    contentDescription = "Account",
                    Modifier.size(50.dp)
                )
                Text(text = "Account")
            }

            Spacer(
                modifier = Modifier
                    .fillMaxHeight()
                    .size(1.dp)
                    .background(Color.Black)
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.clickable { viewModel.navigateToLocation() }
            ) {
                Icon(
                    Icons.Default.LocationOn,
                    contentDescription = "Location",
                    Modifier.size(50.dp)
                )
                Text(text = "Location")
            }

        }

    }
}