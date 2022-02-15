package ru.alira.pets.map

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.google.android.gms.maps.GoogleMapOptions
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker

@Composable
fun MapScreen(
    navController: NavController
) {
    Surface {
        val vidnoe = LatLng(55.5587272964431, 37.69633505359927)
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            googleMapOptionsFactory = {
                GoogleMapOptions().camera(CameraPosition.fromLatLngZoom(vidnoe, 11f))
            }
        ) {
            Marker(
                position = vidnoe,
                title = "Vidnoe",
                snippet = "Marker in Vidnoe"
            )
        }
    }
}