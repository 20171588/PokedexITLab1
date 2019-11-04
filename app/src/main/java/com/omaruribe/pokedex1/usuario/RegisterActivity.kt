package com.omaruribe.pokedex1.usuario

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.omaruribe.pokedex1.R
import com.omaruribe.pokedex1.Realm

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val botonRegistro = findViewById<Button>(R.id.buttonRegistro)

        botonRegistro.setOnClickListener {

            //Crear usuario
            //Validar usuario

        }

    }
}