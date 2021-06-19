package com.example.preparationtointerview.di

import com.example.preparationtointerview.MainActivity
import com.github.terrakok.cicerone.Router
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [SomeModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)
}