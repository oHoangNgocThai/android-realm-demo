package com.example.realmdemo

import io.realm.RealmObject
import io.realm.RealmResults
import io.realm.annotations.LinkingObjects
import io.realm.annotations.PrimaryKey

open class Cat(
    @PrimaryKey()
    var id: Int = 0,

    var name: String = "",

    @LinkingObjects("cats")
    val owners: RealmResults<Person>? = null
) : RealmObject()
