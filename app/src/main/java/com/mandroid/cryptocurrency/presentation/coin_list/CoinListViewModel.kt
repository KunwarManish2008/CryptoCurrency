package com.mandroid.cryptocurrency.presentation.coin_list

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mandroid.cryptocurrency.common.Resource
import com.mandroid.cryptocurrency.domain.use_cases.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 * Created by Manish Kumar on 29/06/22.
 */

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
): ViewModel() {

    private val _state = mutableStateOf(CoinListState())
    val state: State<CoinListState> = _state

    init {
        Log.e("CoinListViewModel", "init")
        getCoins()
    }
    private fun getCoins(){
        getCoinsUseCase().onEach { resultFlow ->
            Log.e("CoinListViewModel", "$resultFlow")
            when(resultFlow) {
                is Resource.Loading -> _state.value = CoinListState(isLoading = true)
                is Resource.Success -> _state.value = CoinListState(coins = resultFlow.data ?: listOf())
                is Resource.Error -> _state.value = CoinListState(error = resultFlow.message ?: "An unexpected error occurred.")
            }
        }.launchIn(viewModelScope)
    }
}