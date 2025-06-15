package com.example.jurymobileapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import com.example.jurymobileapp.data.Screens
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.jurymobileapp.StorageOperations.StorageOperations
import com.example.jurymobileapp.data.GetDaneViewModel
import com.example.jurymobileapp.data.Screens.WyborUczestnikow
import com.example.jurymobileapp.model.Ocena
import com.example.jurymobileapp.screens.Error.ErrorScreen
import com.example.jurymobileapp.screens.OcenaScreen
import com.example.jurymobileapp.screens.WyborUczestnika

import com.example.jurymobileapp.screens.logowanieJurora
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

        composable(route = Screens.WyborUczestnikow.route)
        { bse ->
            val jurorId = bse.arguments?.getString("jurorId")?.toIntOrNull() ?: -1
            val kategoriaId = bse.arguments?.getString("kategoriaId")?.toIntOrNull() ?: -1
            if (jurorId == -1|| kategoriaId == -1) {
                ErrorScreen("Brakuje ID jurora lub kategorii 😵")
                return@composable
            }
            WyborUczestnika(navHostController, getDaneViewModel,jurorId = jurorId, kategoriaId = kategoriaId)

        }
        composable(
            route = Screens.OcenaScreen.route,
            arguments = listOf(
                navArgument("jurorId") { type = NavType.IntType },
                navArgument("uczestnikId") { type = NavType.IntType },
                navArgument("kategoriaId") { type = NavType.IntType }
            )
        ) { bse ->

            val jurorId = bse.arguments?.getInt("jurorId")?: -1
            val uczestnikId = bse.arguments?.getInt("uczestnikId")?: -1
            val kategoriaId = bse.arguments?.getInt("kategoriaId")?: -1

            val juror = getDaneViewModel.jurorzy.find { it.id == jurorId }
            val uczestnik = getDaneViewModel.uczestnicy.find { it.id == uczestnikId }
            val kategoria = getDaneViewModel.kategorie.find { it.id == kategoriaId }



        }


    }

}