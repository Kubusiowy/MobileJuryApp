package com.example.jurymobileapp.data

sealed class Screens(val route:String) {
    object LogowanieJury: Screens(route = "Logowanie_Jury")
    object WyborKategori: Screens(route = "WyborKategori")

}