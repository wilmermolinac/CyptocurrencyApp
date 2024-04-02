package com.wamcstudios.cyptocurrencyapp.presentation.coin_detail

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wamcstudios.calorytracker.navigation.utils.UiEvent
import com.wamcstudios.cyptocurrencyapp.R
import com.wamcstudios.cyptocurrencyapp.core.common.Resource
import com.wamcstudios.cyptocurrencyapp.core.utils.UiText
import com.wamcstudios.cyptocurrencyapp.domain.use_case.CoinUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "CoinDetailViewModel"

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val coinUseCases: CoinUseCases,
) :
    ViewModel() {

    var state by mutableStateOf(CoinDetailState())
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    private var coinDetailJob: Job? = null

    init {

        getNavigationData()

    }

    private fun getNavigationData() {

        coinDetailJob?.cancel()

        viewModelScope.launch {

            coinDetailJob = savedStateHandle.get<String>("coinId")?.let { data ->
                coinUseCases.getCoinDetailById(data).onEach { resource ->

                    when (resource) {
                        is Resource.Error -> {
                            state = state.copy(isLoading = false)
                            _uiEvent.send(
                                UiEvent.ShowSnackBar(
                                    message = resource.message ?: UiText.StringResource(
                                        R.string.msg_error_connection
                                    )
                                )
                            )
                        }

                        is Resource.Loading -> {
                            state = state.copy(isLoading = true)
                        }

                        is Resource.Success -> {
                            val coinDetail = resource.data
                            state = state.copy(isLoading = false, coinDetail = coinDetail)
                            Log.d(TAG, "coinDetail: $coinDetail")
                        }
                    }

                }.launchIn(viewModelScope)

            }
        }

    }


    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }


}