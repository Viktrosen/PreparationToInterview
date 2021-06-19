package com.example.preparationtointerview.navigation

import com.example.preparationtointerview.view.MapsFragment
import com.example.preparationtointerview.view.SettingsFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    fun screenMap() = FragmentScreen { MapsFragment() }
    fun screenSettings() = FragmentScreen{SettingsFragment()}
}