package com.omaruribe.pokedex1.pokemon

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.omaruribe.pokedex1.R
import com.omaruribe.pokedex1.api.ApiService
import com.omaruribe.pokedex1.api.PokemonRespuesta
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_datospokemon.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class DatosPokemon : AppCompatActivity(){

    lateinit var retrofit: Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datospokemon)

        //actionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        var posicion = intent.getStringExtra("posicion")
        var foto = intent.getStringExtra("url")
        var nombre = intent.getStringExtra("name")

        //Toast.makeText(this,datos,Toast.LENGTH_LONG).show()
        //Toast.makeText(this,foto,Toast.LENGTH_LONG).show()

        retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/pokemon/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        obtenerDatosPokemon(posicion)

        var picasso = Picasso.get()
        picasso.load(foto).into(pokeImage)
        pokeShow.text = nombre
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                //Write your logic here
                this.finish()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun obtenerDatosPokemon(url : String) {

        val service = retrofit.create<ApiService>(ApiService::class.java)
        var pokemonRespuestaCall = service.obtenerDatosPokemon(url)

        pokemonRespuestaCall.enqueue(object : Callback<PokemonRespuesta>{

            override fun onFailure(call: Call<PokemonRespuesta>, t: Throwable) {

                Log.e("Pokedex","On failure: "+t.message)
            }

            override fun onResponse(
                call: Call<PokemonRespuesta>,
                response: Response<PokemonRespuesta>
            ) {
                if (response.isSuccessful){
                    var pokemonRespuesta = response.body()
                    var base_experience = pokemonRespuesta!!.base_experience
                    var height = pokemonRespuesta!!.height
                    var weight = pokemonRespuesta!!.weight

                    experienciaSet.text = base_experience.toString()
                    alturaSet.text = height.toString()
                    pesoSet.text = weight.toString()


                }else{
                    Log.e("Pokedex","On failure: " + response.errorBody())
                }
            }
        }
        )

    }
}