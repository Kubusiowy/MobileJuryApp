package com.example.jurymobileapp.api

import com.example.jurymobileapp.model.Juror
import com.example.jurymobileapp.model.Kategoria
import com.example.jurymobileapp.model.Kryterium

import com.example.jurymobileapp.model.OcenaRequest
import com.example.jurymobileapp.model.Uczestnik
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("konkurs_api/jury.php")
    suspend fun getJurorzy(): List<Juror>

    @GET("konkurs_api/kategorie.php")
    suspend fun getKategorie():List<Kategoria>

    @GET("konkurs_api/uczestnicy.php")
    suspend fun getUczestnicy():List<Uczestnik>

    @GET("konkurs_api/kryteria.php")
    suspend fun getKryteria():List<Kryterium>

    @POST("konkurs_api/dodaj_ocene.php")
    suspend fun dodajOcene(@Body ocena: OcenaRequest): Response<ResponseBody>

}