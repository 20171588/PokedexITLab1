package com.omaruribe.pokedex1.usuario

import io.realm.RealmObject

open class Usuario() : RealmObject() {

    var userName : String? = null
    var password : String? = null
}