package com.wamcstudios.cyptocurrencyapp.presentation.coin_list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wamcstudios.calorytracker.navigation.utils.UiEvent
import com.wamcstudios.cyptocurrencyapp.R
import com.wamcstudios.cyptocurrencyapp.core.common.Resource
import com.wamcstudios.cyptocurrencyapp.core.utils.UiText
import com.wamcstudios.cyptocurrencyapp.domain.use_case.CoinUseCases
import com.wamcstudios.cyptocurrencyapp.navigation.routes.NavigationRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(private val coinUseCases: CoinUseCases) : ViewModel() {

    var state by mutableStateOf(CoinListState())
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    private var coinJob: Job? = null

    init {
        getCoinsList()
    }





    fun onEvent(event: CoinListEvent) {
        when (event) {
            is CoinListEvent.OnClickCoin -> {
                viewModelScope.launch {
                    _uiEvent.send(UiEvent.Navigate(route = NavigationRoute.CoinDetail.passData(event.coinId)))
                }
            }
        }
    }

    private fun getCoinsList() {

        coinJob?.cancel()

        coinJob = viewModelScope.launch {
            coinUseCases.getCoins().onEach { resource ->

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
                        state =
                            state.copy(isLoading = false, coinsList = resource.data ?: emptyList())
                    }
                }
            }.launchIn(viewModelScope)

        }

    }


}