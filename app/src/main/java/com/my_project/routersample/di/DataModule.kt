package com.my_project.routersample.di

import com.my_project.routersample.data.DataService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created Максим on 18.04.2019.
 * Copyright © Max
 */
@Module
class DataModule {

    @Provides
    @Singleton
    fun provideDataService() = DataService()
}