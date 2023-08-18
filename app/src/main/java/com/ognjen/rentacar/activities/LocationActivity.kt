package com.ognjen.rentacar.activities

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ognjen.rentacar.AppViewModel
import com.ognjen.rentacar.layout.Footer
import com.ognjen.rentacar.layout.Header

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LocationActivity(viewModel: AppViewModel){
    Scaffold(topBar = {
        Header()
    }, bottomBar = {
        Footer(viewModel)
    }) { contentPadding ->
        Column(modifier = Modifier.padding(contentPadding)) {
            Text(text = "Location")
        }
    }
}