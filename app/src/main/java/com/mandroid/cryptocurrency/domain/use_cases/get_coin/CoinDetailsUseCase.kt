package com.mandroid.cryptocurrency.domain.use_cases.get_coin

import com.mandroid.cryptocurrency.common.Resource
import com.mandroid.cryptocurrency.data.remote.dto.toCoinDetail
import com.mandroid.cryptocurrency.domain.model.CoinDetail
import com.mandroid.cryptocurrency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

/**
 * Created by Manish Kumar on 29/06/22.
 */
class CoinDetailsUseCase @Inject constructor(
    private val coinRepository: CoinRepository
) {

    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> =  flow {
        try{
            emit(Resource.Loading<CoinDetail>())
            val coinDetail = coinRepository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coinDetail))
        }catch (e: HttpException){
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "Unexpected error occurred."))
        }catch (e: IOException){
            emit(Resource.Error<CoinDetail>("Couldn't reach server... Check your internet connection."))
        }
    }
}