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
data class OcenaRequest(
    @Json(name = "jury_id") val juryId: Int,
    @Json(name = "uczestnik_id") val uczestnikId: Int,
    @Json(name = "kryterium_id") val kryteriumId: Int,
    @Json(name = "wartosc") val wartosc: Int
)

