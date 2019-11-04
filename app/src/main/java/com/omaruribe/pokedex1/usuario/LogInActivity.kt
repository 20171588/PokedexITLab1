package com.omaruribe.pokedex1.usuario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.omaruribe.pokedex1.R
import com.omaruribe.pokedex1.pokemon.ListaPokemon

class LogInActivity : AppCompatActivity() {

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

            //Confirmar usuario

            val intent = Intent(this, ListaPokemon::class.java)
            startActivity(intent)
        }


    }
}
