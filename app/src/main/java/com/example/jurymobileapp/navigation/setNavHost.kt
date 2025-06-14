package com.example.jurymobileapp.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.jurymobileapp.data.Screens
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.composable
import com.example.jurymobileapp.data.GetDaneViewModel

import com.example.jurymobileapp.screens.logowanieJurora
import com.example.jurymobileapp.screens.ocenaScreen
import com.example.jurymobileapp.screens.wyborKategorii

@Composable
fun setNavHosts(navHostController:NavHostController)
{
    val getDaneViewModel: GetDaneViewModel =viewModel()
    NavHost(navController = navHostController,startDestination = Screens.LogowanieJury.route)
    {
        composable(route = Screens.LogowanieJury.route)
        {
            logowanieJurora(navHostController,getDaneViewModel)
        }

        composable(route = Screens.WyborKategori.route)
        {
            wyborKategorii(navHostController,getDaneViewModel)
        }

        composable(route = Screens.WyborOceny.route)
        {
            ocenaScreen(navHostController)
        }


    }

}