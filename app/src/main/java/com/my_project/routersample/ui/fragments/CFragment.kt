package com.my_project.routersample.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.my_project.routersample.R
import com.my_project.routersample.presentation.c.CPresenter
import com.my_project.routersample.presentation.c.CView
import com.my_project.routersample.router.FragmentKeys
import com.my_project.routersample.ui.main.MainActivity
import kotlinx.android.synthetic.main.c_fragment.*

/**
 * Created Максим on 18.04.2019.
 * Copyright © Max
 */
class CFragment: MvpAppCompatFragment(),CView {

    companion object {
        fun newInstance(name:String): CFragment {
            val fragment = CFragment()
            val args = Bundle()
            args.putString(FragmentKeys.C_KEY, name)
            fragment.arguments = args
            return fragment
        }
    }

    @JvmField
    @InjectPresenter
    var cPresenter: CPresenter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.c_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initData()
        updateActionBar()
        backButton.setOnClickListener { cPresenter?.onBackButtonClick() }
    }

    private fun name() = arguments?.getString(FragmentKeys.C_KEY)

    private fun initData(){
        name()?.let { personTextView.text = it }
    }

    private fun updateActionBar(){
        val actionBar = (activity as MainActivity).actionBar
        actionBar?.title = context?.resources?.getString(R.string.c_frag)
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }
}