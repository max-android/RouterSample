package com.my_project.routersample.di

import com.my_project.routersample.presentation.a.APresenter
import com.my_project.routersample.presentation.b.BPresenter
import com.my_project.routersample.presentation.c.CPresenter
import com.my_project.routersample.presentation.m.MainFragPresenter
import com.my_project.routersample.presentation.main.MainPresenter
import com.my_project.routersample.ui.fragments.AFragment
import com.my_project.routersample.ui.fragments.BFragment
import com.my_project.routersample.ui.fragments.CFragment
import com.my_project.routersample.ui.fragments.MainFragment
import com.my_project.routersample.ui.main.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        RouterModule::class,
        DataModule::class
    ]
)

interface AppComponent {
    fun injectMainActivity(mainActivity: MainActivity)
    fun injectMainFragment(mFragment: MainFragment)
    fun injectAFragment(aFragment: AFragment)
    fun injectBFragment(bFragment: BFragment)
    fun injectCFragment(cFragment: CFragment)
    fun injectMainPresenter(mainPresenter: MainPresenter)
    fun injectMainFragPresenter(mainFragPresenter: MainFragPresenter)
    fun injectAPresenter(aPresenter: APresenter)
    fun injectBPresenter(bPresenter: BPresenter)
    fun injectCPresenter(cPresenter: CPresenter)
}