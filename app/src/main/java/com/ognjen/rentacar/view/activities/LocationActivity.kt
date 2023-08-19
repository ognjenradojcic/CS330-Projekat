package com.ognjen.rentacar.view.activities

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import com.ognjen.rentacar.view.AppViewModel
import com.ognjen.rentacar.view.layout.Footer
import com.ognjen.rentacar.view.layout.Header

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LocationActivity(viewModel: AppViewModel) {
    Scaffold(topBar = {
        Header()
    }, bottomBar = {
        Footer(viewModel)
    }) { contentPadding ->
        Column(modifier = Modifier.padding(contentPadding)) {
            val metCoordinates = LatLng(43.30728983610683, 21.946998938076703)
            val metState = MarkerState(position = metCoordinates)
            val cameraPosition = rememberCameraPositionState() {
                position = CameraPosition.fromLatLngZoom(metCoordinates, 17.5f)
            }
            GoogleMap(
                modifier = Modifier.fillMaxSize(),
                cameraPositionState = cameraPosition
            ) {
                Marker(
                    state = metState,
                    title = "MetShop"
                )
            }

        }
    }
}