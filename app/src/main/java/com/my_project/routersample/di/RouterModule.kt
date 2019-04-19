package com.my_project.routersample.di

import android.content.Context
import com.my_project.routersample.router.Router
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RouterModule(private val context: Context) {

    @Provides
    @Singleton
    fun provideRouter(): Router = Router(context)
}