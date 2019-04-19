package com.my_project.routersample.presentation.b

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
class BPresenter: MvpPresenter<BView>()  {

    @Inject
    lateinit var router: Router

    init {
        App.appComponent.injectBPresenter(this)
    }

    fun onStartAction(name:String){
        router.forward(Screen.C_SCREEN,name)
    }

}