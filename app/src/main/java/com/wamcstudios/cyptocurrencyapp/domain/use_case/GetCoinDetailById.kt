package com.wamcstudios.cyptocurrencyapp.domain.use_case

import com.wamcstudios.cyptocurrencyapp.core.common.Resource
import com.wamcstudios.cyptocurrencyapp.domain.model.CoinDetail
import com.wamcstudios.cyptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCoinDetailById @Inject constructor(private val repository: CoinRepository) {

    suspend operator fun invoke(coinId:String):Flow<Resource<CoinDetail>>{
        return repository.getCoinById(coinId)
    }
}