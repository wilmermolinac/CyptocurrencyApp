package com.wamcstudios.cyptocurrencyapp.data.mapper

import com.wamcstudios.cyptocurrencyapp.data.remote.dto.CoinDto
import com.wamcstudios.cyptocurrencyapp.domain.model.Coin
import com.wamcstudios.cyptocurrencyapp.domain.model.CoinType

fun CoinDto.toCoin(): Coin {
    return Coin(
        id = id,
        isActive = isActive,
        isNew = isNew,
        name = name,
        rank = rank,
        symbol = symbol,
        type = CoinType.fromString(type)
    )
}

fun Coin.toCoinDto(): CoinDto {
    return CoinDto(
        id = id,
        isNew = isNew,
        isActive = isActive,
        name = name,
        rank = rank,
        symbol = symbol,
        type = type.name
    )
}