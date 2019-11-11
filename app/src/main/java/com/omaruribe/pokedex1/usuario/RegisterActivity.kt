package com.omaruribe.pokedex1.usuario

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.omaruribe.pokedex1.R
import io.realm.Realm

class RegisterActivity : AppCompatActivity() {

    val realm = Realm.getDefaultInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val botonRegistro = findViewById<Button>(R.id.buttonRegistro)

        botonRegistro.setOnClickListener {
            if (checkUser()==true){
                registerUser()
            }else{
                Toast.makeText(this,"Nombre de usuario ya registrado",Toast.LENGTH_SHORT).show()
            }

        }

    }

    fun registerUser(){

        val username = findViewById<EditText>(R.id.usuarioRegistro).text.toString()
        val password = findViewById<EditText>(R.id.passwordRegistro).text.toString()

        if (username=="" || password==""){
            Toast.makeText(this,"Complete los campos necesarios",Toast.LENGTH_SHORT).show()
        }else{
            realm.beginTransaction()
            val usuario = realm.createObject(Usuario::class.java)
            usuario.userName = username
            usuario.password = password
            realm.commitTransaction()
            Toast.makeText(this,"Se ha registrado correctamente",Toast.LENGTH_SHORT).show()

            finish()

            //var intent = Intent(this, LogInActivity::class.java)

            //intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        }
    }

    fun checkUser(): Boolean? {

        val username = findViewById<EditText>(R.id.usuarioRegistro).text.toString()
        var realmResults = realm.where(Usuario::class.java).contains("userName",username).findFirst()
        return realmResults == null
    }


    fun viewUsers(){

        var realmResults = realm.where(Usuario::class.java).findAll()
        var k = ""
        for (i in 0..realmResults.size){
            k = k + realmResults.get(i)!!.userName
        }
        Toast.makeText(this,k,Toast.LENGTH_SHORT).show()
    }
}