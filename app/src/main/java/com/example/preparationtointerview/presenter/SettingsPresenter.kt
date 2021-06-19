package com.example.preparationtointerview.presenter

import android.view.View
import androidx.fragment.app.Fragment
import com.example.preparationtointerview.model.MainModel
import com.google.android.gms.maps.model.LatLng

class SettingsPresenter:PresenterContract {

    var view: Fragment? = null
    override fun onAttachView(view: Fragment) {
        this.view = view
    }

    override fun onDetachView() {
        view = null
    }

    fun add(pair: Pair<LatLng,String>){
        MainModel.arrayOfMarkers.add(pair)
    }

    fun delete(position:Int){
        MainModel.arrayOfMarkers.removeAt(position)
    }
}