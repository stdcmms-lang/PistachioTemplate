package com.jetbrains.kmpapp.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
actual fun MapView(
    modifier: Modifier,
    latitude: Double,
    longitude: Double,
    zoom: Float
) {
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(
            LatLng(latitude, longitude),
            zoom
        )
    }
    
    GoogleMap(
        modifier = modifier,
        cameraPositionState = cameraPositionState
    )
}
