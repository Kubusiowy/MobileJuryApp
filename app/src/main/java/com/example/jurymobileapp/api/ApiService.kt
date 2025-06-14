package com.example.jurymobileapp.api

import com.example.jurymobileapp.model.Juror
import com.example.jurymobileapp.model.Kategoria
import retrofit2.http.GET

interface ApiService {
    @GET("konkurs_api/jury.php")
    suspend fun getJurorzy(): List<Juror>

    @GET("konkurs_api/kategorie.php")
    suspend fun getKategorie():List<Kategoria>
}