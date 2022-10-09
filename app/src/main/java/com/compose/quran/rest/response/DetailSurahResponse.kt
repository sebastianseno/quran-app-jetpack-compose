package com.compose.quran.rest.response
import com.google.gson.annotations.SerializedName

data class DetailSurahResponse(
    @SerializedName("status")
    val status: Boolean = false,
    @SerializedName("nomor")
    val nomor: Int = 0,
    @SerializedName("nama")
    val nama: String = "",
    @SerializedName("nama_latin")
    val namaLatin: String = "",
    @SerializedName("jumlah_ayat")
    val jumlahAyat: Int = 0,
    @SerializedName("tempat_turun")
    val tempatTurun: String = "",
    @SerializedName("arti")
    val arti: String = "",
    @SerializedName("deskripsi")
    val deskripsi: String = "",
    @SerializedName("audio")
    val audio: String = "",
    @SerializedName("ayat")
    val ayat: List<Ayat> = listOf()
)

data class Ayat(
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("surah")
    val surah: Int = 0,
    @SerializedName("nomor")
    val nomor: Int = 0,
    @SerializedName("ar")
    val ar: String = "",
    @SerializedName("tr")
    val tr: String = "",
    @SerializedName("idn")
    val idn: String = ""
)

data class SuratSelanjutnya(
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("nomor")
    val nomor: Int = 0,
    @SerializedName("nama")
    val nama: String = "",
    @SerializedName("nama_latin")
    val namaLatin: String = "",
    @SerializedName("jumlah_ayat")
    val jumlahAyat: Int = 0,
    @SerializedName("tempat_turun")
    val tempatTurun: String = "",
    @SerializedName("arti")
    val arti: String = "",
    @SerializedName("deskripsi")
    val deskripsi: String = "",
    @SerializedName("audio")
    val audio: String = ""
)

data class SuratSebelumnya(
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("nomor")
    val nomor: Int = 0,
    @SerializedName("nama")
    val nama: String = "",
    @SerializedName("nama_latin")
    val namaLatin: String = "",
    @SerializedName("jumlah_ayat")
    val jumlahAyat: Int = 0,
    @SerializedName("tempat_turun")
    val tempatTurun: String = "",
    @SerializedName("arti")
    val arti: String = "",
    @SerializedName("deskripsi")
    val deskripsi: String = "",
    @SerializedName("audio")
    val audio: String = ""
)