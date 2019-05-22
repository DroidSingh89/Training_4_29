package com.example.training_4_29.ui.activity

import android.location.Location
import android.os.Bundle
import com.example.training_4_29.BaseActivity
import com.example.training_4_29.R
import com.example.training_4_29.manager.LocationManager
import com.example.training_4_29.manager.PermissionManager
import com.example.training_4_29.utils.toast
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_maps.*

class MapsActivity : BaseActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var location: Location
    val sydney = LatLng(-34.0, 151.0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        btnStartLocationUpdates.setOnClickListener {
            LocationManager.startListening(this) {
            toast("$it")
            }
        }
        btnStopLocationUpdates.setOnClickListener {
            LocationManager.stopListening()
        }
    }
    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        updateMap(sydney)
    }

    private fun updateMap(latLng: LatLng) {
        // Add a marker in Sydney and move the camera
        mMap.addMarker(MarkerOptions().position(latLng).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng))
    }

    override fun onStart() {
        super.onStart()
        PermissionManager.checkPermission(this, PermissionManager.PERMISSION.LOCATION) { isGranted ->
            if (isGranted) {
                LocationManager.getLastKnownLocation(this) {
                    location = it
                    updateMap(LatLng(location.latitude, location.longitude))
                }
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        PermissionManager.onPermissionResult(requestCode, permissions, grantResults) { isGranted ->
            if (isGranted) {
                LocationManager.getLastKnownLocation(this) {
                    location = it
                    updateMap(LatLng(location.latitude, location.longitude))
                }

            }
        }
    }
}
