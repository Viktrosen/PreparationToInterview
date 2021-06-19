package com.example.preparationtointerview.presenter

import androidx.fragment.app.Fragment

interface PresenterContract {
    fun onAttachView(view: Fragment)
    fun onDetachView()
}