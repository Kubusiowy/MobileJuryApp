package com.example.jurymobileapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jurymobileapp.data.GetDaneViewModel

@Composable
fun wyborKategorii(navController: NavController,viewModel: GetDaneViewModel) {

    val kategorie = viewModel.kategorie

    Column(modifier = Modifier.fillMaxSize().padding(16.dp))
    {
        kategorie.forEach { kategoria ->

            Text(text = kategoria.nazwa)

        }

    }



}
