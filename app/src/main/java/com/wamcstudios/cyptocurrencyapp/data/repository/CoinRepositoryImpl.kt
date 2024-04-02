package com.wamcstudios.cyptocurrencyapp.data.repository

import android.net.http.HttpException
import com.wamcstudios.cyptocurrencyapp.R
import com.wamcstudios.cyptocurrencyapp.core.common.Resource
import com.wamcstudios.cyptocurrencyapp.core.utils.UiText
import com.wamcstudios.cyptocurrencyapp.data.mapper.toCoin
import com.wamcstudios.cyptocurrencyapp.data.mapper.toCoinDetail
import com.wamcstudios.cyptocurrencyapp.data.remote.ApiService
import com.wamcstudios.cyptocurrencyapp.domain.model.Coin
import com.wamcstudios.cyptocurrencyapp.domain.model.CoinDetail
import com.wamcstudios.cyptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(private val api: ApiService) : CoinRepository {

    override suspend fun getCoins(): Flow<Resource<List<Coin>>> = flow {

        try {
            emit(Resource.Loading())

            val coins = api.getCoins().map {
                it.toCoin()
            }


            emit(Resource.Success(coins))


        } catch (e: retrofit2.HttpException) {
            e.printStackTrace()
            val message = e.localizedMessage ?: "error unknown"
            emit(Resource.Error(message = UiText.DynamicString(message)))
        } catch (e: IOException) {
            e.printStackTrace()
            emit(Resource.Error(message = UiText.StringResource(R.string.msg_error_connection)))
        } catch (e: Exception) {

            e.printStackTrace()
            val message = e.message ?: "error unknown"
            emit(Resource.Error(message = UiText.DynamicString(message)))

        }

    }

    override suspend fun getCoinById(coinId: String): Flow<Resource<CoinDetail>> = flow {

        try {
            emit(Resource.Loading())

            val coinDetail = api.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coinDetail))

        } catch (e: retrofit2.HttpException) {
            e.printStackTrace()
            val message = e.localizedMessage ?: "error unknown"
            emit(Resource.Error(message = UiText.DynamicString(message)))
        } catch (e: IOException) {
            e.printStackTrace()
            emit(Resource.Error(message = UiText.StringResource(R.string.msg_error_connection)))
        } catch (e: Exception) {

            e.printStackTrace()
            val message = e.message ?: "error unknown"
            emit(Resource.Error(message = UiText.DynamicString(message)))

        }


    }
}