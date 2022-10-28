package com.mouredev.pokemonjetpackcompose.model

/**
 * Created by MoureDev by Brais Moure on 28/10/22.
 * www.mouredev.com
 */

data class PokemonList(val results: List<Pokemon>)

data class Pokemon(val name: String, val url: String) {

    val id: Int
        get() {
            val components = url.split("/")
            return components[components.size - 2].toIntOrNull() ?: 0
        }

    val imageUrl: String
        get() = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$id.png"
}