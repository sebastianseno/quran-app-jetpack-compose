package com.compose.quran.rest.response
import com.google.gson.annotations.SerializedName


class SurahListResponse : ArrayList<SurahListResponseItem>()

data class SurahListResponseItem(
    @SerializedName("nomor")
    val number: Int = 0,
    @SerializedName("nama")
    val name: String = "",
    @SerializedName("nama_latin")
    val latinName: String = "",
    @SerializedName("jumlah_ayat")
    val numberOfVerses: Int = 0,
    @SerializedName("tempat_turun")
    val revelationPlace: String = "",
    @SerializedName("arti")
    val meaning: String = "",
    @SerializedName("deskripsi")
    val description: String = "",
    @SerializedName("audio")
    val audio: String = ""
)