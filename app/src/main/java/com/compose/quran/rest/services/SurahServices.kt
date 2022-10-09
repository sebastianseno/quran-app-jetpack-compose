package com.compose.quran.rest.services

import com.compose.quran.rest.response.SurahListResponseItem
import retrofit2.http.GET

interface SurahServices {

    @GET("surat")
    suspend fun getSurah(): List<SurahListResponseItem>
}