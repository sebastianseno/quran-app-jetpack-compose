package com.compose.quran.domain.usecase

import com.compose.quran.domain.util.Resource
import com.compose.quran.rest.response.SurahListResponse
import com.compose.quran.rest.services.SurahServices
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SurahUseCase @Inject constructor(
    private val api: SurahServices
) {
    operator fun invoke(): Flow<Resource<SurahListResponse>> = flow {
        emit(Resource.Loading())
        runCatching {
            api.getSurah()
        }.onSuccess {
            emit(Resource.Success(it))
        }.onFailure {
            emit(Resource.Error(message = it.message ?: "An unknown error occurred.", data = null))
        }
    }
}
