package com.compose.quran.rest.services

import com.compose.quran.rest.response.DetailSurahResponse
import com.compose.quran.rest.response.SurahListResponseItem
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SurahServices {

    @GET("surat")
    suspend fun getSurah(): List<SurahListResponseItem>

    @GET("surat/{nomor}")
    suspend fun getDetailSurah(
        @Path("nomor") number: String,
    ): DetailSurahResponse
}