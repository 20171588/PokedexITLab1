package com.omaruribe.pokedex1

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

class Realm : Application() {

    override fun onCreate() {
        super.onCreate()

        Realm.init(this)

        val config = RealmConfiguration.Builder().name("usuario.realm").build()

        val realm = Realm.getInstance(config)
    }
}