package com.compose.quran.rest.response

data class Surah(
    val ayah: Int,
    val name: String,
    val arab: String,
    val number: Int,
    val place: String
)

fun SurahListResponseItem.toSurah(): Surah {
    return Surah(
        ayah = numberOfVerses,
        name = latinName,
        arab = name,
        number = number,
        place = revelationPlace
    )
}