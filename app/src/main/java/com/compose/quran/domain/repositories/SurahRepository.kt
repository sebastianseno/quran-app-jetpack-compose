package com.compose.quran.domain.repositories
import com.compose.quran.rest.response.SurahListResponseItem

interface QuranRepository {
    suspend fun getSurahData(): List<SurahListResponseItem>
 }