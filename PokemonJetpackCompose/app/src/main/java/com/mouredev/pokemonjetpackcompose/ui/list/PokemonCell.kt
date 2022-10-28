package com.mouredev.pokemonjetpackcompose.ui.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.mouredev.pokemonjetpackcompose.model.Pokemon

/**
 * Created by MoureDev by Brais Moure on 28/10/22.
 * www.mouredev.com
 */

@Composable
fun PokemonCell(pokemon: Pokemon) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(8.dp)
    ) {
        AsyncImage(
            model = pokemon.imageUrl,
            "Pokémon image",
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .background(Color.Gray.copy(alpha = 0.1f))
                .padding(8.dp)
        )
        Text(
            "#${pokemon.id}",
            style = MaterialTheme.typography.h6,
            fontWeight = FontWeight.Light,
            modifier = Modifier.padding(4.dp)
        )
        Text(
            pokemon.name.replaceFirstChar { it.uppercase() },
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Medium
        )
        Spacer(modifier = Modifier.fillMaxWidth())
    }

}