package com.my_project.routersample.ui.fragments

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.my_project.routersample.R
import com.my_project.routersample.data.entities.Person
import com.my_project.routersample.presentation.a.APresenter
import com.my_project.routersample.presentation.a.AView
import com.my_project.routersample.ui.MyAdapter
import com.my_project.routersample.ui.main.MainActivity
import kotlinx.android.synthetic.main.a_fragment.*
import org.jetbrains.anko.support.v4.longToast


class AFragment : MvpAppCompatFragment(), AView {

    companion object {
        fun newInstance(): AFragment {
            return AFragment()
        }
    }

    @JvmField
    @InjectPresenter
    var aPresenter: APresenter? = null

    private lateinit var myAdapter: MyAdapter
    private var screen = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.a_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initViews()
        updateActionBar()
        if (savedInstanceState == null && !screen) aPresenter?.initData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        screen = true
    }

    override fun showPersons(persons: List<Person>) {
        myAdapter.setData(persons)
    }

    override fun showError(message: String) {
        longToast(message)
    }

    private fun initViews() {
        myAdapter = MyAdapter { aPresenter?.onItemClick(it) }
        personRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@AFragment.context, LinearLayoutManager.VERTICAL, false)
            addItemDecoration(DividerItemDecoration(this@AFragment.context, LinearLayout.VERTICAL))
            adapter = myAdapter
        }
    }

    private fun updateActionBar() {
        val actionBar = (activity as MainActivity).actionBar
        actionBar?.title = context?.resources?.getString(R.string.a_frag)
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }

}