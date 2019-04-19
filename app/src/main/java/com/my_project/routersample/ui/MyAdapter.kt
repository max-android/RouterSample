package com.my_project.routersample.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.my_project.routersample.R
import com.my_project.routersample.data.entities.Person

/**
 * Created Максим on 18.04.2019.
 * Copyright © Max
 */
class MyAdapter (private val action: (Person) -> Unit) : RecyclerView.Adapter<MyAdapter.MyHolder>() {

    private val items: MutableList<Person> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_person, parent, false)
        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val user = items[position]
        holder.bindTo(user)
    }

    override fun getItemCount() = items.size

    fun setData(users: List<Person>) {
        items.clear()
        items.addAll(users)
        notifyDataSetChanged()
    }

    inner class MyHolder(private val containerView: View) : RecyclerView.ViewHolder(containerView) {

        private var nameTextView = containerView.findViewById(R.id.nameTextView) as TextView
        private var ageTextView = containerView.findViewById(R.id.ageTextView) as TextView

        init {
            containerView.setOnClickListener { action(items[layoutPosition]) }
        }

        fun bindTo(users: Person) = with(users) {
            nameTextView.text = name
            ageTextView.text = age.toString()
        }
    }
}