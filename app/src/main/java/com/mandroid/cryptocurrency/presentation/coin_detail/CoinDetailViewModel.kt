package com.mandroid.cryptocurrency.presentation.coin_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mandroid.cryptocurrency.common.Constants
import com.mandroid.cryptocurrency.common.Resource
import com.mandroid.cryptocurrency.domain.use_cases.get_coin.CoinDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 * Created by Manish Kumar on 29/06/22.
 */

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinDetailsUseCase: CoinDetailsUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _state = mutableStateOf(CoinDetailState())
    val state: State<CoinDetailState> = _state


    init {
        savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let { getCoin(it) }
    }

    private fun getCoin(coinId: String){
        getCoinDetailsUseCase(coinId).onEach { resultFlow ->
            when(resultFlow){
                is Resource.Loading -> _state.value = CoinDetailState(isLoading = true)
                is Resource.Success -> _state.value = CoinDetailState(coinDetail = resultFlow.data)
                is Resource.Error -> _state.value = CoinDetailState(error = resultFlow.message ?: "An unexpected error occurred.")
            }
        }.launchIn(viewModelScope)
    }
}