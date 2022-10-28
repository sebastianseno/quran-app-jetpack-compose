package com.compose.quran.rest.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.compose.quran.domain.repositories.QuranRepository
import com.compose.quran.paging.GithubUserMediator
import com.compose.quran.rest.response.DetailSurahResponse
import com.compose.quran.rest.response.Item
import com.compose.quran.rest.response.SurahListResponseItem
import com.compose.quran.rest.response.UserResponse
import com.compose.quran.rest.services.SurahServices
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class QuranRepositoryImpl @Inject constructor(
    private val api: SurahServices
) : QuranRepository {

    override suspend fun getSurahData(): List<SurahListResponseItem> {
        return api.getSurah()
    }

    override suspend fun getDetailSurah(number: String): DetailSurahResponse {
        return api.getDetailSurah(number)
    }

    override suspend fun getUserResponse(): Flow<PagingData<Item>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                GithubUserMediator(api)
            }
        ).flow
    }

}