package com.my_project.routersample.presentation.m

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
class MainFragPresenter: MvpPresenter<MainFragView>(){

    @Inject
    lateinit var router: Router

    init {
        App.appComponent.injectMainFragPresenter(this)
    }

    fun onListButtonClick()= router.forward(Screen.A_SCREEN)

}