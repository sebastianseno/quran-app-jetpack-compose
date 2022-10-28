package com.compose.quran.ui.surah.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.compose.quran.domain.usecase.SurahUseCase
import com.compose.quran.domain.util.Resource
import com.compose.quran.rest.repository.QuranRepositoryImpl
import com.compose.quran.rest.response.Item
import com.compose.quran.rest.response.User
import com.compose.quran.ui.surah.SurahState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SurahViewModel @Inject constructor(
    private val surahUseCase: SurahUseCase,
    private val surahRepositoryImpl: QuranRepositoryImpl
) : ViewModel() {

    var stateUser by mutableStateOf(ScreenState())

    private val _state = mutableStateOf(SurahState())
    val state: State<SurahState> = _state

    private val _userGithub = MutableStateFlow<PagingData<Item>>(PagingData.empty())
    val userGithub = _userGithub

    init {
//        getSurahList()
        getGithubUser()
    }

    private fun getGithubUser() {
        viewModelScope.launch {
            surahRepositoryImpl.getUserResponse().cachedIn(viewModelScope).collect {
                _userGithub.value = it
            }
        }
    }

    private fun getSurahList() {
        surahUseCase.getSurah().onEach { result ->
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
        }.launchIn(viewModelScope)
    }
}


data class ScreenState(
    val isLoading: Boolean = false,
    val items: List<User> = emptyList(),
    val error: String? = null,
    val endReached: Boolean = false,
    val page: Int = 0
)