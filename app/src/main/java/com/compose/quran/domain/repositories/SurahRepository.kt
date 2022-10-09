package com.compose.quran.domain.repositories
import com.compose.quran.rest.response.SurahListResponse

interface SurahRepository {
    suspend fun getSurahData(): Result<SurahListResponse>
}