package com.omaruribe.pokedex1.usuario

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Usuario() : RealmObject() {

    var userName : String = ""
    var password : String = ""
}