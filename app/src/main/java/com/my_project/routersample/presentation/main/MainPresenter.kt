package com.my_project.routersample.presentation.main

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.my_project.routersample.App
import com.my_project.routersample.router.Router
import com.my_project.routersample.router.Screen
import javax.inject.Inject

/**
 * Created Максим on 18.04.2019.
 * Copyright © Max
 */
@InjectViewState
class MainPresenter : MvpPresenter<MainView>() {

    @Inject
    lateinit var router: Router

    init {
        App.appComponent.injectMainPresenter(this)
    }

    fun setMainScreen(){
        router.replace(Screen.MAIN_SCREEN)
    }

    fun pressBack(){
        router.back()
    }
}