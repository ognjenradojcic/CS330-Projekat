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
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ognjen.rentacar.data.dto.response.InvoiceResponse
import com.ognjen.rentacar.data.dto.response.ProductResponse
import com.ognjen.rentacar.view.AppViewModel
import com.ognjen.rentacar.view.layout.DeleteConfirmationDialog
import com.ognjen.rentacar.view.layout.Footer
import com.ognjen.rentacar.view.layout.Header

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrdersActivity(viewModel: AppViewModel) {

    val telefon = ProductResponse.ProductCategoryResponse(1, "Telefon")
    val product = ProductResponse(1, "A54", "Samsung", 500.0, telefon);

    val invoiceItem = InvoiceResponse.InvoiceItemResponse(1, product, 1)
    val invoiceItem2 = InvoiceResponse.InvoiceItemResponse(1, product, 1)

    val invoices = listOf(
        InvoiceResponse(1, "Bulevar", "21.06.2023.", 1, listOf(invoiceItem, invoiceItem2)),
        InvoiceResponse(2, "Trg", "17.08.2023.", 1, listOf(invoiceItem)),
        InvoiceResponse(3, "Pobedina", "14.01.2023.", 2, listOf(invoiceItem)),
        InvoiceResponse(4, "Park", "25.06.2023", 3, listOf(invoiceItem))

    )

    Scaffold(topBar = {
        Header()
    }, bottomBar = {
        Footer(viewModel)
    }) { contentPadding ->
        Column(modifier = Modifier.padding(contentPadding)) {

            Text(
                text = "Orders",
                Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 10.dp),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )

            OrdersList(ordersList = invoices, viewModel)
        }
    }
}


@Composable
fun OrdersList(ordersList: List<InvoiceResponse>, viewModel: AppViewModel) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(ordersList) { item ->
            OrderCard(item, viewModel)
        }
    }
}

@Composable
fun OrderCard(item: InvoiceResponse, viewModel: AppViewModel) {
    var isDialogVisible by remember { mutableStateOf(false) }

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
                OrderProductList(productList = item.items)

                Text(
                    text = "${item.address}, ${item.orderedDate}",

                    modifier = Modifier.padding(bottom = 4.dp),
                    fontSize = 18.sp
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(16.dp)
                    .clickable { isDialogVisible = true }
            ) {
                Icon(
                    Icons.Default.Delete,
                    contentDescription = "Delete",
                    Modifier.size(50.dp),
                    tint = MaterialTheme.colorScheme.error
                )
                Text(text = "Delete", fontSize = 16.sp)
            }
            if (isDialogVisible) {
                DeleteConfirmationDialog(
                    onDeleteConfirmed = {
                        //TODO implement delete

                        isDialogVisible = false
                    },

                    onDismiss = {
                        isDialogVisible = false
                    })
            }
        }
    }
}

@Composable
fun OrderProductList(
    productList: List<InvoiceResponse.InvoiceItemResponse>,
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        for (item in productList) {
            OrderProductItem(item)
        }
    }
}

@Composable
fun OrderProductItem(item: InvoiceResponse.InvoiceItemResponse) {
    Text(
        text = "${item.product.manufacturer}  ${item.product.name}",
        modifier = Modifier.padding(bottom = 4.dp),
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    )
    Text(
        text = "${item.product.price} €",

        modifier = Modifier.padding(bottom = 4.dp),
        fontSize = 18.sp
    )
}