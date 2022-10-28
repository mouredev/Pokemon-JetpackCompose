package com.mouredev.pokemonjetpackcompose.api

import com.mouredev.pokemonjetpackcompose.model.Pokemon
import com.mouredev.pokemonjetpackcompose.model.PokemonList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * Created by MoureDev by Brais Moure on 28/10/22.
 * www.mouredev.com
 */
object PokemonAPI {

    interface PokemonAPI {

        @GET("pokemon?limit=151")
        fun loadPokemon(): Call<PokemonList>

    }

    fun loadPokemon(success: (pokemonList: List<Pokemon>) -> Unit, failure: () -> Unit) {

        val retrofit = Retrofit.Builder().baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create()).build()
        val service = retrofit.create(PokemonAPI::class.java)

        service.loadPokemon().enqueue(object: Callback<PokemonList> {

            override fun onResponse(call: Call<PokemonList>, response: Response<PokemonList>) {
                success(response.body()?.results ?: listOf())
            }

            override fun onFailure(call: Call<PokemonList>, t: Throwable) {
                failure()
            }

        })
    }

}