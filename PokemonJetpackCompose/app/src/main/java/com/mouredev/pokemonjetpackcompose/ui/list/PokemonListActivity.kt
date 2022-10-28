package com.mouredev.pokemonjetpackcompose.ui.list

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mouredev.pokemonjetpackcompose.ui.theme.PokemonJetpackComposeTheme

/**
 * Created by MoureDev by Brais Moure on 28/10/22.
 * www.mouredev.com
 */

class PokemonListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokemonJetpackComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    PokemonList()
                }
            }
        }
    }
}

@Composable
fun PokemonList() {

    val viewModel = PokemonListViewModel()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Pokémon list")
                }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier.padding(padding)
        ) {
            items(viewModel.pokemonList) { pokemon ->
                PokemonCell(pokemon)
            }
        }
    }

}


@Preview(showSystemUi = true)
@Composable
fun PokemonListDefaultPreview() {
    PokemonJetpackComposeTheme {
        PokemonList()
    }
}