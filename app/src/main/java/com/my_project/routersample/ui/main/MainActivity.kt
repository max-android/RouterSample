package com.my_project.routersample.ui.main

import android.os.Bundle
import android.support.v7.app.ActionBar
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.my_project.routersample.App
import com.my_project.routersample.R
import com.my_project.routersample.presentation.main.MainPresenter
import com.my_project.routersample.presentation.main.MainView
import com.my_project.routersample.router.Router
import javax.inject.Inject

class MainActivity : MvpAppCompatActivity(), MainView {

    @JvmField
    @InjectPresenter
    var mPresenter: MainPresenter? = null

    @Inject
    lateinit var router: Router
    var actionBar: ActionBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.appComponent.injectMainActivity(this)
        setContentView(R.layout.activity_main)
        router.create(supportFragmentManager)
        initViews()
        if (savedInstanceState == null) mPresenter?.setMainScreen()
    }

    override fun onSupportNavigateUp(): Boolean {
        mPresenter?.pressBack()
        actionBar?.setDisplayHomeAsUpEnabled(false)
        return true
    }

    private fun initViews() {
        actionBar = supportActionBar
    }
}
