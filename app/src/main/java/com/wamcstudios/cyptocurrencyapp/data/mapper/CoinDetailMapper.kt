package com.wamcstudios.cyptocurrencyapp.data.mapper

import com.wamcstudios.cyptocurrencyapp.data.remote.dto.CoinDetailDto
import com.wamcstudios.cyptocurrencyapp.domain.model.CoinDetail
import com.wamcstudios.cyptocurrencyapp.domain.model.CoinType

fun CoinDetailDto.toCoinDetail(): CoinDetail {
    return CoinDetail(
        id = id,
        description = description,
        developmentStatus = developmentStatus,
        firstDataAt = firstDataAt,
        hardwareWallet = hardwareWallet,
        hashAlgorithm = hashAlgorithm,
        isActive = isActive,
        isNew = isNew,
        lastDataAt = lastDataAt,
        links = links,
        linksExtended = linksExtended.map {
            it.url
        },
        logo = logo,
        message = message,
        name = name,
        openSource = openSource,
        orgStructure = orgStructure,
        proofType = proofType,
        rank = rank,
        startedAt = startedAt,
        symbol = symbol,
        teamMember = teamMember,
        tags = tags.map {
            it.name
        },
        whitepaper = whitepaper,
        type = CoinType.fromString(type)
    )
}