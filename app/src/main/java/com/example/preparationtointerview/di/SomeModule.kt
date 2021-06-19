package com.example.preparationtointerview.di

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class SomeModule {

    @Provides
    @Singleton
    fun getCicerone(): Cicerone<Router> = Cicerone.create()

    @Provides
    @Singleton
    fun getRouter(cicerone: Cicerone<Router>): Router = cicerone.router

    @Provides
    @Singleton
    fun getNavigatorHolder(cicerone: Cicerone<Router>) = cicerone.getNavigatorHolder()
}