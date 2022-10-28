package com.mouredev.pokemonjetpackcompose.ui.list

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.mouredev.pokemonjetpackcompose.api.PokemonAPI
import com.mouredev.pokemonjetpackcompose.model.Pokemon

/**
 * Created by MoureDev by Brais Moure on 28/10/22.
 * www.mouredev.com
 */
class PokemonListViewModel: ViewModel() {

    var pokemonList: List<Pokemon> by mutableStateOf(listOf())

    init {
        loadData()
    }

    private fun loadData() {

        PokemonAPI.loadPokemon({ pokemon ->
            pokemonList = pokemon
        }, {
            println("Error")
        })
    }

}