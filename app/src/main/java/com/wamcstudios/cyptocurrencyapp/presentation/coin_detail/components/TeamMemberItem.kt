package com.wamcstudios.cyptocurrencyapp.presentation.coin_detail.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.wamcstudios.calorytracker.ui.theme.LocalSpacing
import com.wamcstudios.cyptocurrencyapp.data.remote.dto.TeamMember

@Composable
fun TeamMemberItem(modifier: Modifier = Modifier, teamMember: TeamMember) {

    val spacing = LocalSpacing.current
    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = teamMember.name,
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
        )
        Text(
            text = teamMember.position,
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Medium)
        )

        Spacer(modifier = Modifier.height(spacing.spaceNanoSmall))

        HorizontalDivider()

        Spacer(modifier = Modifier.height(spacing.spaceNanoSmall))


    }

}

@Preview
@Composable
fun TeamMemberItemPreview() {
    TeamMemberItem(
        teamMember = TeamMember(
            id = "01", name = "Satoshi Nakamoto", position = "Founder"
        )
    )
}