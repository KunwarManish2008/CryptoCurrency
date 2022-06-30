package com.mandroid.cryptocurrency.domain.model

import com.mandroid.cryptocurrency.data.remote.dto.Tag
import com.mandroid.cryptocurrency.data.remote.dto.TeamMember

/**
 * Created by Manish Kumar on 28/06/22.
 */
data class CoinDetail(
    val coinId: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<Tag>,
    val team: List<TeamMember>
)
