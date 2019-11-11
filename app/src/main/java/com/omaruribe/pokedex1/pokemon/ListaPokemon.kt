package com.omaruribe.pokedex1.pokemon

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.omaruribe.pokedex1.R
import com.omaruribe.pokedex1.api.ApiService
import com.omaruribe.pokedex1.api.PokemonRespuesta
import kotlinx.android.synthetic.main.activity_listapokemon.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ListaPokemon : AppCompatActivity(){

    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: LinearLayoutManager

    private lateinit var retrofit: Retrofit
    private lateinit var listaPokeAdapter : PokeAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listapokemon)


        retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        obtenerDatos()


        viewManager = LinearLayoutManager(this)



    }


    private fun obtenerDatos() {

        val service = retrofit.create<ApiService>(ApiService::class.java)
        var pokemonRespuestaCall = service.obtenerListaPokemon()

        pokemonRespuestaCall.enqueue(object : Callback<PokemonRespuesta> {

            override fun onFailure(call: Call<PokemonRespuesta>, t: Throwable) {

                Log.e("Pokedex","On failure: "+t.message)
            }

            override fun onResponse(
                call: Call<PokemonRespuesta>,
                response: Response<PokemonRespuesta>
            ) {
                if (response.isSuccessful){

                    var pokemonRespuesta = response.body()
                    var listaPokemon = pokemonRespuesta!!.results

                    listaPokeAdapter = PokeAdapter(listaPokemon)

                    viewAdapter = listaPokeAdapter

                    recyclerPoke.apply {
                        setHasFixedSize(true)
                        layoutManager = viewManager
                        adapter = viewAdapter
                    }

                }else{
                    Log.e("Pokedex","On failure: " + response.errorBody())
                }
            }
        }
        )
    }
}