package com.omaruribe.pokedex1.usuario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.omaruribe.pokedex1.R
import com.omaruribe.pokedex1.pokemon.ListaPokemon
import io.realm.Realm

class LogInActivity : AppCompatActivity() {

    val realm = Realm.getDefaultInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val botonRegistro = findViewById<Button>(R.id.registro)
        val botonIngreso = findViewById<Button>(R.id.login)

        botonRegistro.setOnClickListener {

            val intent = Intent(this, RegisterActivity::class.java)

            startActivity(intent)
        }

        botonIngreso.setOnClickListener {

            checkLogin()
        }


    }

    fun checkLogin(){

        val username = findViewById<EditText>(R.id.username)
        val password = findViewById<EditText>(R.id.password)

        var realmResults = realm.where(Usuario::class.java).contains("userName",username.text.toString()).findFirst()
        if(realmResults!=null){
            if (realmResults.password == password.text.toString()){
                Toast.makeText(this,"Ha ingresado correctamente",Toast.LENGTH_SHORT).show()
                username.setText("")
                password.setText("")
                val intent = Intent(this,ListaPokemon::class.java)
                startActivity(intent)
            }else{
                username.setText("")
                password.setText("")
                Toast.makeText(this,"Constraseña Incorrecta",Toast.LENGTH_SHORT).show()
            }
        }else{
            Toast.makeText(this,"Usuario Incorrecto",Toast.LENGTH_SHORT).show()
            username.setText("")
            password.setText("")
        }
    }
}
