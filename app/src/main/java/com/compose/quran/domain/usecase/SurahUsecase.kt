package com.compose.quran.domain.usecase

import com.compose.quran.domain.repositories.QuranRepository
import com.compose.quran.domain.util.Resource
import com.compose.quran.rest.response.DetailSurahResponse
import com.compose.quran.rest.response.SurahListResponseItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SurahUseCase @Inject constructor(
    private val quranRepository: QuranRepository
) {
    fun getSurah(): Flow<Resource<List<SurahListResponseItem>>> = flow {
        emit(Resource.Loading())
        runCatching {
            quranRepository.getSurahData()
        }.onSuccess {
            emit(Resource.Success(it))
        }.onFailure {
            emit(Resource.Error(message = it.message ?: "An unknown error occurred.", data = null))
        }
    }

    fun getDetailSurah(number: String): Flow<Resource<DetailSurahResponse>> = flow {
        emit(Resource.Loading())
        runCatching {
            quranRepository.getDetailSurah(number)
        }.onSuccess {
            emit(Resource.Success(it))
        }.onFailure {
            emit(Resource.Error(message = it.message ?: "An unknown error occurred.", data = null))
        }
    }

}

