package com.example.jurymobileapp.data

sealed class Screens(val route:String) {
    object LogowanieJury: Screens(route = "Logowanie_Jury")
    object WyborKategori: Screens(route = "WyborKategori")
    object WyborOceny:Screens(route= "Wybor_Oceny")
    object WyborUczestnikow: Screens(route = "wybor_uczestnika/{id}"){
        fun passJurorId(id:Int):String{
            return "wybor_uczestnika/$id"
        }
    }
}