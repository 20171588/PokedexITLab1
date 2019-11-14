package com.omaruribe.pokedex1.api

import com.omaruribe.pokedex1.pokemon.DatosPokemon
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Url

interface ApiService {

    @GET("pokemon")
    fun obtenerListaPokemon() : Call<PokemonRespuesta>

    @GET
    fun obtenerDatosPokemon(@Url url: String) : Call<PokemonRespuesta>

}