package com.my_project.routersample.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.my_project.routersample.R
import com.my_project.routersample.data.entities.Person
import com.my_project.routersample.presentation.b.BPresenter
import com.my_project.routersample.presentation.b.BView
import com.my_project.routersample.router.FragmentKeys
import com.my_project.routersample.ui.main.MainActivity
import kotlinx.android.synthetic.main.b_fragment.*

class BFragment: MvpAppCompatFragment(),BView {

    companion object {
        fun newInstance(person: Person): BFragment {
            val fragment = BFragment()
            val args = Bundle()
            args.putSerializable(FragmentKeys.B_KEY, person)
            fragment.arguments = args
            return fragment
        }
    }

    @JvmField
    @InjectPresenter
    var bPresenter: BPresenter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.b_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initData()
        updateActionBar()
        startButton.setOnClickListener { bPresenter?.onStartAction(nameTextView.text.toString()) }
    }

    private fun person() = arguments?.getSerializable(FragmentKeys.B_KEY)

    private fun initData(){
        (person() as? Person)?.let{ nameTextView.text = it.name }
    }

    private fun updateActionBar(){
        val actionBar = (activity as MainActivity).actionBar
        actionBar?.title = context?.resources?.getString(R.string.b_frag)
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }
}