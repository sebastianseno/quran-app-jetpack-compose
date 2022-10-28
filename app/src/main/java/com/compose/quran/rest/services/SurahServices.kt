package com.compose.quran.rest.services

import com.compose.quran.rest.response.DetailSurahResponse
import com.compose.quran.rest.response.SurahListResponseItem
import com.compose.quran.rest.response.UserResponse
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

    @GET("search/repositories")
    suspend fun searchGithubUser(
        @Query ("q") keyword: String = "Android",
        @Query ("sort") sort: String = "repositories",
        @Query ("order") order: String = "asc",
        @Query ("per_page") limit: Int = 10,
        @Query ("page") page: Int
    ): UserResponse

}