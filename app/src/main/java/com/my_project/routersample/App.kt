package com.my_project.routersample

import android.app.Application
import com.my_project.routersample.di.AppComponent
import com.my_project.routersample.di.DaggerAppComponent
import com.my_project.routersample.di.DataModule
import com.my_project.routersample.di.RouterModule

/**
 * Created Максим on 18.04.2019.
 * Copyright © Max
 */
class App: Application() {

    companion object {
        @JvmStatic
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .dataModule(DataModule())
            .routerModule(RouterModule(applicationContext))
            .build()
    }
}