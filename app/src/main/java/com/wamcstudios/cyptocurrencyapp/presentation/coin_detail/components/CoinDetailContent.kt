package com.wamcstudios.cyptocurrencyapp.presentation.coin_detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.wamcstudios.calorytracker.ui.theme.LocalSpacing
import com.wamcstudios.cyptocurrencyapp.R
import com.wamcstudios.cyptocurrencyapp.core.presentation.components.CryptocurrencyDefaultLoading
import com.wamcstudios.cyptocurrencyapp.data.remote.dto.TeamMember
import com.wamcstudios.cyptocurrencyapp.presentation.coin_detail.CoinDetailState

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CoinDetailContent(modifier: Modifier = Modifier, state: CoinDetailState) {

    val item = state.coinDetail
    val spacing = LocalSpacing.current

    Box(modifier = modifier.fillMaxSize()) {


        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(spacing.spaceMedium)
        ) {

            item?.let { item ->
                item {
                    Column(modifier = Modifier.fillMaxWidth()) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Text(
                                modifier = Modifier.weight(1f),
                                text = "${item.rank}. ${item.name} (${item.symbol})",
                                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
                            )

                            val textActive = if (item.isActive) {
                                stringResource(id = R.string.active)
                            } else {
                                stringResource(id = R.string.inactive)
                            }


                            Text(
                                text = textActive,
                                style = MaterialTheme.typography.titleSmall.copy(color = MaterialTheme.colorScheme.primary)
                            )

                        }


                    }


                }

                item {

                    Spacer(modifier = Modifier.height(spacing.spaceMicroSmall))

                    Text(
                        text = stringResource(id = R.string.description),
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.ExtraBold)
                    )

                    Spacer(modifier = Modifier.height(spacing.spaceSmall))

                    if (item.description.isNotBlank()) {
                        Text(
                            text = item.description,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    } else {
                        Text(
                            text = stringResource(id = R.string.none),
                            style = MaterialTheme.typography.bodyMedium
                        )

                    }

                }


                item {

                    Spacer(modifier = Modifier.height(spacing.spaceSmall))
                    Text(
                        text = stringResource(id = R.string.tags),
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.ExtraBold)
                    )

                    Spacer(modifier = Modifier.height(spacing.spaceMicroSmall))

                    FlowRow(modifier = Modifier.fillMaxWidth()) {
                        item.tags.forEach {
                            FilterChip(
                                selected = false,
                                onClick = { },
                                label = {
                                    Text(
                                        text = it,
                                        style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
                                    )
                                },
                                colors = FilterChipDefaults.filterChipColors(
                                    containerColor = MaterialTheme.colorScheme.primary,
                                    labelColor = Color.White,
                                ), shape = CircleShape
                            )


                            Spacer(modifier = Modifier.width(spacing.spaceMicroSmall))
                        }
                    }

                }


                item {
                    Spacer(modifier = Modifier.height(spacing.spaceSmall))
                    Text(
                        text = stringResource(id = R.string.team_members),
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.ExtraBold)
                    )

                    Spacer(modifier = Modifier.height(spacing.spaceMicroSmall))

                    if (item.teamMember.isNullOrEmpty()) {
                        Text(text = stringResource(id = R.string.none))
                    } else {
                        item.teamMember.forEach { teamMember ->
                            TeamMemberItem(teamMember = teamMember)
                        }
                    }

                }

            }


        }


        CryptocurrencyDefaultLoading(isLoading = state.isLoading)
    }
}