package com.my_project.routersample.presentation.main

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

/**
 * Created Максим on 18.04.2019.
 * Copyright © Max
 */

@StateStrategyType(AddToEndSingleStrategy::class)
interface MainView: MvpView {

}