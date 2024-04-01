package com.wamcstudios.cyptocurrencyapp.domain.model

import com.google.gson.annotations.SerializedName
import com.wamcstudios.cyptocurrencyapp.data.remote.dto.Links
import com.wamcstudios.cyptocurrencyapp.data.remote.dto.LinksExtended
import com.wamcstudios.cyptocurrencyapp.data.remote.dto.Tag
import com.wamcstudios.cyptocurrencyapp.data.remote.dto.TeamMember
import com.wamcstudios.cyptocurrencyapp.data.remote.dto.Whitepaper

data class CoinDetail(
    val description: String,
    val developmentStatus: String,
    val firstDataAt: String,
    val hardwareWallet: Boolean,
    val hashAlgorithm: String,
    val id: String,
    val isActive: Boolean,
    val isNew: Boolean,
    val lastDataAt: String,
    val links: Links,
    val linksExtended: List<LinksExtended>,
    val logo: String,
    val message: String,
    val name: String,
    val openSource: Boolean,
    val orgStructure: String,
    val proofType: String,
    val rank: Int,
    val startedAt: String,
    val symbol: String,
    val tags: List<String>,
    val teamMember: List<TeamMember>,
    val type: CoinType,
    val whitepaper: Whitepaper,
)
