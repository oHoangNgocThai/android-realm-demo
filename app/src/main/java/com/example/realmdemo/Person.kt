package com.example.realmdemo

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Person(
    @PrimaryKey
    var id: Int = 0,

    var name: String = "",

    var age: Int = 0,

    var dog: Dog? = null,

    var cats: RealmList<Cat> = RealmList()
) : RealmObject()
