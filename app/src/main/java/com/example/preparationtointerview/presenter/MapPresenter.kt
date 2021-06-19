package com.example.preparationtointerview.presenter

import android.view.View
import androidx.fragment.app.Fragment
import com.example.preparationtointerview.model.MainModel
import com.google.android.gms.maps.model.LatLng

class MapPresenter:PresenterContract {



    var view: Fragment? = null
    override fun onAttachView(view: Fragment) {
        this.view = view

    }

    override fun onDetachView() {
        view = null

    }

    fun addMarker(pair: Pair<LatLng,String>){
        MainModel.add(pair)
    }

    fun getMarkers():MutableList<Pair<LatLng,String>>{
        return MainModel.arrayOfMarkers
    }




}