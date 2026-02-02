package com.jetbrains.kmpapp.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.interop.UIKitView
import kotlinx.cinterop.ExperimentalForeignApi
import kotlin.math.pow
import platform.CoreLocation.CLLocationCoordinate2DMake
import platform.MapKit.MKCoordinateRegionMake
import platform.MapKit.MKCoordinateSpanMake
import platform.MapKit.MKMapView
import platform.MapKit.MKMapTypeStandard

@OptIn(ExperimentalForeignApi::class)
@Composable
actual fun MapView(
    modifier: Modifier,
    latitude: Double,
    longitude: Double,
    zoom: Float
) {
    UIKitView(
        factory = {
            MKMapView().apply {
                mapType = MKMapTypeStandard
                val coordinate = CLLocationCoordinate2DMake(latitude, longitude)
                // Calculate region span based on zoom level
                // Zoom level 15 typically corresponds to ~0.01 degrees span
                val span = 360.0 / (256.0 * 2.0.pow(zoom.toDouble()))
                val spanObj = MKCoordinateSpanMake(span, span)
                val region = MKCoordinateRegionMake(coordinate, spanObj)
                setRegion(region, animated = false)
            }
        },
        modifier = modifier
    )
}
