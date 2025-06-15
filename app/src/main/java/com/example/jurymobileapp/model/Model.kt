package com.example.jurymobileapp.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Juror(
    @Json(name = "id") val id:Int,
    @Json(name = "imie") val imie:String,
    @Json(name = "nazwisko") val nazwisko:String
)


@JsonClass(generateAdapter = true)
data class Kategoria(
    @Json(name = "id") val id:Int,
    @Json(name = "nazwa") val nazwa:String,
)

@JsonClass(generateAdapter = true)
data class Kryterium(
    @Json(name = "id") val id: Int,
    @Json(name = "kategoria_id") val idKategorii: Int,
    @Json(name = "nazwa") val nazwa: String,
    @Json(name = "maks_punkty") val maksPunkty: Int
)

@JsonClass(generateAdapter = true)
data class Uczestnik(
    @Json(name = "id") val id: Int,
    @Json(name = "imie") val imie: String,
    @Json(name = "nazwisko") val nazwisko: String
)


@JsonClass(generateAdapter = true)
data class Ocena(
    @Json(name = "id") val id: Int,
    @Json(name = "id_jurora") val idJurora: Int,
    @Json(name = "id_uczestnika") val idUczestnika: Int,
    @Json(name = "id_kryterium") val idKryterium: Int,
    @Json(name = "punkty") val punkty: Int
)