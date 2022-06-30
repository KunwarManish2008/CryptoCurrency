package com.mandroid.cryptocurrency.domain.use_cases.get_coins

import android.util.Log
import com.mandroid.cryptocurrency.common.Resource
import com.mandroid.cryptocurrency.data.remote.dto.toCoin
import com.mandroid.cryptocurrency.domain.model.Coin
import com.mandroid.cryptocurrency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

/**
 * Created by Manish Kumar on 29/06/22.
 */
class GetCoinsUseCase @Inject constructor(
    private val coinRepository: CoinRepository
) {

    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        Log.e("GetCoinsUseCase", "invoke")
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = coinRepository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))

        }catch (e: HttpException){
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "An unexpected error occurred."))
        }catch (e: IOException){
            emit(Resource.Error<List<Coin>>("Couldn't reach server... Check internet connection."))
        }

    }
}