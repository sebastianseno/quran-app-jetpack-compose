package com.compose.quran.rest.repository

import com.compose.quran.domain.repositories.QuranRepository
import com.compose.quran.rest.response.SurahListResponseItem
import com.compose.quran.rest.services.SurahServices
import javax.inject.Inject

class QuranRepositoryImpl @Inject constructor(
    private val api: SurahServices
) : QuranRepository {

    override suspend fun getSurahData(): List<SurahListResponseItem> {
        return api.getSurah()
    }

}