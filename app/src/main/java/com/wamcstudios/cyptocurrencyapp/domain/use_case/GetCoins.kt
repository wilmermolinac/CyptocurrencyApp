package com.wamcstudios.cyptocurrencyapp.domain.use_case

import com.wamcstudios.cyptocurrencyapp.core.common.Resource
import com.wamcstudios.cyptocurrencyapp.domain.model.Coin
import com.wamcstudios.cyptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCoins @Inject constructor(private val repository: CoinRepository) {

    suspend operator fun invoke(): Flow<Resource<List<Coin>>> {
        return repository.getCoins()
    }
}