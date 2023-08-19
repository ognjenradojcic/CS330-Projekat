package com.ognjen.rentacar.view.activities

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ognjen.rentacar.data.dto.response.ProductResponse
import com.ognjen.rentacar.view.AppViewModel
import com.ognjen.rentacar.view.layout.Footer
import com.ognjen.rentacar.view.layout.Header

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeActivity(viewModel: AppViewModel) {

    val telefon = ProductResponse.ProductCategoryResponse(1, "Telefon")
    val products = listOf(
        ProductResponse(1, "A54", "Samsung", 500.0, telefon),
        ProductResponse(2, "S23", "Samsung", 1200.0, telefon),
        ProductResponse(3, "13", "Iphone", 800.0, telefon),
        ProductResponse(4, "14 Pro", "Iphone", 1400.0, telefon)
    )

    Scaffold(topBar = {
        Header()
    }, bottomBar = {
        Footer(viewModel)
    }) { contentPadding ->
        Column(modifier = Modifier.padding(contentPadding)) {

            Text(
                text = "Products",
                Modifier.align(CenterHorizontally),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )

            ProductList(productList = products, viewModel)
        }
    }
}


@Composable
fun ProductList(productList: List<ProductResponse>, viewModel: AppViewModel) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(productList) { item ->
            ProductCard(item, viewModel)
        }
    }
}

@Composable
fun ProductCard(item: ProductResponse, viewModel: AppViewModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
    ) {
        Row(horizontalArrangement = Arrangement.SpaceBetween) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .weight(1f)
            ) {
                Text(
                    text = "${item.manufacturer}  ${item.name}",
                    modifier = Modifier.padding(bottom = 4.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
                Text(
                    text = "${item.price} €",

                    modifier = Modifier.padding(bottom = 4.dp),
                    fontSize = 18.sp
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(16.dp)
                    .clickable { viewModel.navigateToHome() }
            ) {
                Icon(
                    Icons.Default.ShoppingCart,
                    contentDescription = "Order",
                    Modifier.size(50.dp)
                )
                Text(text = "Order")
            }
        }
    }
}