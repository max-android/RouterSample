package com.my_project.routersample.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.my_project.routersample.R
import com.my_project.routersample.presentation.m.MainFragPresenter
import com.my_project.routersample.presentation.m.MainFragView
import com.my_project.routersample.ui.main.MainActivity
import kotlinx.android.synthetic.main.main_fragment.*

/**
 * Created Максим on 18.04.2019.
 * Copyright © Max
 */
class MainFragment: MvpAppCompatFragment(),MainFragView  {

    companion object {
        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }

    @JvmField
    @InjectPresenter
    var mPresenter: MainFragPresenter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.main_fragment,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        listButton.setOnClickListener { mPresenter?.onListButtonClick() }
        updateActionBar()
    }

    private fun updateActionBar(){
        val actionBar = (activity as MainActivity).actionBar
        actionBar?.title = context?.resources?.getString(R.string.main_frag)
        actionBar?.setDisplayHomeAsUpEnabled(false)
    }
}