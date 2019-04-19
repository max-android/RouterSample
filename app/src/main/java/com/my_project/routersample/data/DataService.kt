package com.my_project.routersample.data

import com.my_project.routersample.data.entities.Person
import io.reactivex.Single

class DataService {

    fun persons(): Single<List<Person>> = Single.fromCallable { listPersons }

    private val listPersons = listOf(
        Person("Name1-fr1", 23),
        Person("Name2-fr1", 24),
        Person("Name3-fr1", 25),
        Person("Name4-fr1", 26),
        Person("Name5-fr1", 27),
        Person("Name6-fr1", 28)
    )
}