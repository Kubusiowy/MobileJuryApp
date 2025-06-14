package com.example.jurymobileapp.data

import com.example.jurymobileapp.model.Kategoria
import com.example.jurymobileapp.model.Uczestnik

sealed class Screens(val route:String) {
    object LogowanieJury: Screens(route = "Logowanie_Jury")
    object WyborKategori: Screens(route = "WyborKategori")
    object OcenaScreen:Screens(route= "ocena/{jurorId}/{uczestnikId}/{kategoriaId}"){

        fun passArgs(jurorId:Int, uczestnikId:Int, kategoriaId: Int):String{
            return "ocena/$jurorId/$uczestnikId/$kategoriaId"
        }

    }

    object WyborUczestnikow: Screens(route = "wybor_uczestnika/{jurorId}/{kategoriaId}"){
        fun passIds(jurorId:Int,kategoriaId:Int):String{
            return "wybor_uczestnika/$jurorId/$kategoriaId"
        }
    }
}