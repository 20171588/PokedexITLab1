package com.omaruribe.pokedex1.api

import retrofit2.http.GET
import retrofit2.Call

interface ApiService {

    @GET("pokemon")
    fun obtenerListaPokemon() : Call<PokemonRespuesta>

}