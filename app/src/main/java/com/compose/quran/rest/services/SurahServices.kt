package com.compose.quran.rest.services

import com.compose.quran.rest.response.DetailSurahResponse
import com.compose.quran.rest.response.SearchResult
import com.compose.quran.rest.response.SurahListResponseItem
import com.compose.quran.rest.response.UserResponse
import retrofit2.http.GET
import retrofit2.http.Headers
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

    @Headers("Authorization: Client-ID 3cd527962960d2560d1b1f888fcd2535d523d24608137593e14302ecf102cd2a")
    @GET("/search/photos")
    suspend fun searchImages(
        @Query("query") query: String,
        @Query("per_page") perPage: Int
    ): SearchResult

}