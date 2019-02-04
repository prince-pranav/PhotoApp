package com.pntechworld.photoapp.di

import com.pntechworld.photoapp.MainActivity
import dagger.Component
import main.java.com.pntechworld.photoapp.di.ApiModule
import main.java.com.pntechworld.photoapp.di.AppModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(AppModule::class), (ApiModule::class)])
interface DiApiComponent {

    fun inject(mainActivity : MainActivity)

}