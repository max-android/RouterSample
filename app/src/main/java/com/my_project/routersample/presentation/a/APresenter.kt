package com.my_project.routersample.presentation.a

import android.annotation.SuppressLint
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.my_project.routersample.App
import com.my_project.routersample.data.DataService
import com.my_project.routersample.data.entities.Person
import com.my_project.routersample.router.Router
import com.my_project.routersample.router.Screen
import javax.inject.Inject

/**
 * Created Максим on 18.04.2019.
 * Copyright © Max
 */
@InjectViewState
class APresenter: MvpPresenter<AView>() {

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var dataService:DataService

    init {
        App.appComponent.injectAPresenter(this)
    }

    @SuppressLint("CheckResult")
    fun initData(){
        dataService.persons().subscribe(
            { viewState.showPersons(it) },
            { viewState.showError(it.message?:"null") }
        )
    }

    fun onItemClick(person:Person){
        router.forward(Screen.B_SCREEN,person)
    }
}