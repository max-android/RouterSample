package com.my_project.routersample.router

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import com.my_project.routersample.R
import com.my_project.routersample.data.entities.Person
import com.my_project.routersample.ui.fragments.AFragment
import com.my_project.routersample.ui.fragments.BFragment
import com.my_project.routersample.ui.fragments.CFragment
import com.my_project.routersample.ui.fragments.MainFragment


class Router(private val context:Context) {

    lateinit var fragmentManager: FragmentManager

    fun create(fManager: FragmentManager){
        this.fragmentManager = fManager
    }

    fun replace(screen: Screen,data:Any = Any()){
        applyCommand(screen,Command.REPLACE,data)
    }

    fun forward(screen: Screen,data:Any = Any()){
        applyCommand(screen,Command.FORWARD,data)
    }

    fun back(){
       fragmentManager.popBackStack()
    }

    fun backTo(nameFrag:String){
        fragmentManager.popBackStackImmediate(nameFrag,FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }

    fun backStackCount() = fragmentManager.backStackEntryCount

    fun launchActivity(intent: Intent){
        context.startActivity(intent)
    }

   private  fun applyCommand(screen:Screen, command: Command,data:Any) {
        fragmentManager.beginTransaction()
            .replace(R.id.main_container, getFragment(screen,data))
            .apply { if (command == Command.FORWARD) addToBackStack(screen.name) }
            .setCustomAnimations(R.animator.slide_in_left, R.animator.slide_in_right)
            .commitAllowingStateLoss()
    }

    private fun getFragment(screen: Screen,data:Any): Fragment {
        return when (screen) {
            Screen.MAIN_SCREEN -> MainFragment.newInstance()
            Screen.A_SCREEN -> AFragment.newInstance()
            Screen.B_SCREEN -> BFragment.newInstance(data as Person)
            Screen.C_SCREEN -> CFragment.newInstance(data as String)
        }
    }
}