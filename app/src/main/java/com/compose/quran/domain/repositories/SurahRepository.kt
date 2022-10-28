package com.compose.quran.domain.repositories
import androidx.paging.PagingData
import com.compose.quran.rest.response.*
import kotlinx.coroutines.flow.Flow

interface QuranRepository {
    suspend fun getSurahData(): List<SurahListResponseItem>
    suspend fun getDetailSurah(number: String): DetailSurahResponse
    suspend fun getUserResponse(): Flow<PagingData<Item>>
 }