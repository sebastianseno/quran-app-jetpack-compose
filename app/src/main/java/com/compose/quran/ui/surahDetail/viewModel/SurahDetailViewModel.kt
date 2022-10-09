package com.compose.quran.ui.surahDetail.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compose.quran.common.Constants
import com.compose.quran.domain.usecase.SurahUseCase
import com.compose.quran.domain.util.Resource
import com.compose.quran.ui.surah.SurahState
import com.compose.quran.ui.surahDetail.SurahDetailState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SurahDetailViewModel @Inject constructor(
    private val surahUseCase: SurahUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(SurahDetailState())
    val state: State<SurahDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_SURAH)?.let {
            getSurahDetailList(it)
        }
    }

    private fun getSurahDetailList(nomor : String) {
        surahUseCase.getDetailSurah(nomor).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = SurahDetailState(surah = result.data)
                }
                is Resource.Error -> {
                    _state.value = SurahDetailState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                else -> {
                    _state.value = SurahDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}