package com.my_project.routersample.presentation.c

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
class CPresenter: MvpPresenter<CView>(){

    @Inject
    lateinit var router: Router

    init {
        App.appComponent.injectCPresenter(this)
    }

    fun onBackButtonClick(){
       router.backTo(Screen.A_SCREEN.name)
    }
}
