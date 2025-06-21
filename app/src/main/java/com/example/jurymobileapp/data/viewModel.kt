package com.example.jurymobileapp.data

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jurymobileapp.StorageOperations.StorageOperations
import com.example.jurymobileapp.api.RetrofitClient
import com.example.jurymobileapp.model.Juror
import com.example.jurymobileapp.model.Kategoria
import com.example.jurymobileapp.model.Kryterium
import com.example.jurymobileapp.model.OcenaRequest
import com.example.jurymobileapp.model.Uczestnik
import kotlinx.coroutines.launch
import kotlin.toString

class GetDaneViewModel: ViewModel(){

    var jurorzy by mutableStateOf<List<Juror>>(emptyList())
    private set

    var kategorie by mutableStateOf<List<Kategoria>>(emptyList())
        private set

    var kryteria by mutableStateOf<List<Kryterium>>(emptyList())
    private set


    var uczestnicy by mutableStateOf<List<Uczestnik>>(emptyList())

    var zalogowanyJuror by mutableStateOf<Juror?>(null)
        private set



    fun zaloguj(juror: Juror,storage: StorageOperations) {
        zalogowanyJuror = juror
        viewModelScope.launch {
            storage.saveJurorId(juror.id)
            Log.d("storage","udało sie zapisać id jurora: ${juror.imie} ${juror.nazwisko}, id: ${juror.id}")
        }
    }

    init{
        fetchJurorzy()
        fetchKategorie()
        fetchUczestnicy()
        fetchKryteria()
    }

    private fun fetchJurorzy(){
        Log.d("api", jurorzy.toString())
        viewModelScope.launch {
            try{
                jurorzy = RetrofitClient.api.getJurorzy()
                Log.d("api","udało się pobrać jurorów ${jurorzy}")
            }catch (e: Exception){
                println("Błąd pobierania jurorów: ${e.message}")
                Log.d("api","nie udało się pobrać jurorów ${e.message}")
            }
        }
    }


    private fun fetchKategorie(){
        Log.d("api", kategorie.toString())
        viewModelScope.launch {
            try{
                kategorie = RetrofitClient.api.getKategorie()
                Log.d("api","udało się pobrać kategorii ${kategorie}")
            }catch (e: Exception){
                println("Błąd pobierania kategorii: ${e.message}")
                Log.d("api","nie udało się pobrać kategorii ${e.message}")
            }
        }
    }

    private fun fetchUczestnicy()
    {

        viewModelScope.launch {
            try {
                uczestnicy = RetrofitClient.api.getUczestnicy()
                Log.d("api","udało się pobrac uczestników ${uczestnicy}")


            }catch(e: Exception){
                println("Błąd pobierania uczestnikow: ${e.message}")
                Log.d("api","nie udało się pobrać uczestnikow ${e.message}")
            }
        }
    }

    private fun fetchKryteria()
    {

        viewModelScope.launch {
            try {
               kryteria  = RetrofitClient.api.getKryteria()
                Log.d("api","udało się pobrac kryteria ${kryteria}")


            }catch(e: Exception){
                println("Błąd pobierania kryteriow: ${e.message}")
                Log.d("api","nie udało się pobrać krteriow ${e.message}")
            }
        }
    }

}


class OcenyViewModel : ViewModel() {

    var status by mutableStateOf<String?>(null)
        private set

    fun wyslijOcene(ocena: OcenaRequest) {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.api.dodajOcene(ocena)

                if (response.isSuccessful) {
                    val body = response.body()?.toString()
                    if (body?.contains("\"success\":true") == true) {
                        status = "Sukces"
                        Log.d("Ocena", "Dodano ocenę")
                    } else {
                        status = "Błąd serwera: $body"
                        Log.e("Ocena", status!!)
                    }
                } else {
                    status = "Błąd HTTP: ${response.code()}"
                    Log.e("Ocena", status!!)
                }

            } catch (e: Exception) {
                status = "Wyjątek: ${e.message}"
                Log.e("Ocena", status!!)
            }
        }
    }

}




