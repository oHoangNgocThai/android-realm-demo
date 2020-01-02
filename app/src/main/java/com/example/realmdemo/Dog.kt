package com.example.realmdemo

import io.realm.RealmObject
import io.realm.RealmResults
import io.realm.annotations.LinkingObjects
import io.realm.annotations.PrimaryKey

open class Dog(
    @PrimaryKey
    var id: Int =0,

    var name: String = "",

    @LinkingObjects("dog")
    val owners: RealmResults<Person>? = null
) : RealmObject()
