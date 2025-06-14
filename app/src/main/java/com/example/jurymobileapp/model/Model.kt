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

