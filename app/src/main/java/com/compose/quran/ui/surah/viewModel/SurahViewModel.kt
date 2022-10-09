package com.compose.quran.ui.surah.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compose.quran.domain.usecase.SurahUseCase
import com.compose.quran.domain.util.Resource
import com.compose.quran.ui.surah.SurahState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SurahViewModel @Inject constructor(
    private val surahUseCase: SurahUseCase,
): ViewModel() {

    private val _state = mutableStateOf(SurahState())
    val state: State<SurahState> = _state

    init {
        getSurahList()
    }

    private fun getSurahList() {
        viewModelScope.launch {
            surahUseCase().onEach { result ->
                when (result) {
                    is Resource.Success -> {
                        _state.value = SurahState(surah = result.data)
                    }
                    is Resource.Error -> {
                        _state.value = SurahState(
                            error = result.message ?: "An unexpected error occured"
                        )
                    }
                    else -> {
                        _state.value = SurahState(isLoading = true)
                    }
                }
            }
        }
    }
}