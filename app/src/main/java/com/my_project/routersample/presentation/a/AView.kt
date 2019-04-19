package com.my_project.routersample.presentation.a

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.my_project.routersample.data.entities.Person

/**
 * Created Максим on 18.04.2019.
 * Copyright © Max
 */
@StateStrategyType(AddToEndSingleStrategy::class)
interface AView: MvpView {
    fun showPersons(persons:List<Person>)
    @StateStrategyType(SkipStrategy::class)
    fun showError(message:String)
}