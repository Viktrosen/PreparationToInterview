package com.example.preparationtointerview.view

import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import com.example.preparationtointerview.R
import com.example.preparationtointerview.databinding.FragmentMapsBinding
import com.example.preparationtointerview.presenter.MapPresenter
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions


class MapsFragment :  BaseFragment<FragmentMapsBinding>(),GoogleMap.OnMarkerClickListener{
    private lateinit var lastLocation: Location
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private val presenter:MapPresenter = MapPresenter()

    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1
    }

    fun setUpMap(){
        if (activity?.let {
                ActivityCompat.checkSelfPermission(
                    it,
                    android.Manifest.permission.ACCESS_FINE_LOCATION)
            } != PackageManager.PERMISSION_GRANTED) {
            activity?.let {
                ActivityCompat.requestPermissions(
                    it,
                    arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), LOCATION_PERMISSION_REQUEST_CODE)
            }
            return
        }
    }

    private val callback = OnMapReadyCallback { map ->

        map.setOnMapLongClickListener {
            map.addMarker(MarkerOptions().position(it).title("Новый маркер"))
            presenter.addMarker(Pair(it,"Новый маркер"))
        }
        for(marker:Pair<LatLng,String> in presenter.getMarkers()){
        map.addMarker(MarkerOptions().position(marker.first).title(marker.second))
        }

        setUpMap()

        // 1
        map.isMyLocationEnabled = true

// 2
        activity?.let {
            fusedLocationClient.lastLocation.addOnSuccessListener(it) { location ->
                // Got last known location. In some rare situations this can be null.
                // 3
                if (location != null) {
                    lastLocation = location
                    val currentLatLng = LatLng(location.latitude, location.longitude)
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLatLng, 12f))
                }
            }
        }
    }





    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(activity)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
        presenter.onAttachView(this)
    }

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    )= FragmentMapsBinding.inflate(inflater, container, false)

    override fun onMarkerClick(p0: Marker): Boolean =false

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDetachView()
    }

}