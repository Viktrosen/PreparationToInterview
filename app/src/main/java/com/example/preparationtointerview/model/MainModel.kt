package com.example.preparationtointerview.model

import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker

open class MainModel {


    companion object{
        var arrayOfMarkers = mutableListOf<Pair<LatLng,String>>(
            Pair<LatLng, String>(LatLng(93.0, 151.0),"First"),
            Pair<LatLng, String>(LatLng(36.0, 22.0),"Second"),
            Pair<LatLng, String>(LatLng(54.0, 82.0),"Third"),
            Pair<LatLng, String>(LatLng(-34.0, 151.0),"Fourth")

        )

        fun add(pair: Pair<LatLng,String>){
            arrayOfMarkers.add(pair)
        }

        fun delete(position:Int){
            arrayOfMarkers.removeAt(position)
        }
    }




}