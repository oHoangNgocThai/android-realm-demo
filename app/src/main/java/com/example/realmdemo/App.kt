package com.example.realmdemo

import android.app.Application
import io.realm.Realm

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Realm.init(this) //init realmdb this covers all use of realm    within the project.
    }
}
