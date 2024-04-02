package com.wamcstudios.cyptocurrencyapp.presentation.coin_list.components

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.wamcstudios.calorytracker.ui.theme.LocalSpacing
import com.wamcstudios.cyptocurrencyapp.R
import com.wamcstudios.cyptocurrencyapp.core.presentation.components.CryptocurrencyDefaultLoading
import com.wamcstudios.cyptocurrencyapp.domain.model.Coin
import com.wamcstudios.cyptocurrencyapp.presentation.coin_list.CoinListEvent
import com.wamcstudios.cyptocurrencyapp.presentation.coin_list.CoinListState

@Composable
fun CoinListContent(
    modifier: Modifier = Modifier,
    state: CoinListState,
    onEvent: (CoinListEvent) -> Unit,
) {

    val spacing = LocalSpacing.current
    val focusManager = LocalFocusManager.current

    var isFocused by remember {
        mutableStateOf(false)
    }


    Box(modifier = modifier
        .fillMaxSize()
        .pointerInput(Unit) {
            detectTapGestures(onTap = {
                focusManager.clearFocus()
            })
        }) {

        LazyColumn(
            modifier = Modifier.fillMaxSize(), contentPadding = PaddingValues(
                top = spacing.spaceMediumExtra,
                start = spacing.spaceMedium,
                end = spacing.spaceMedium,
                bottom = spacing.spaceLargeMedium
            ), verticalArrangement = Arrangement.spacedBy(spacing.spaceSmall)
        ) {

            item {
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .onFocusChanged {
                            isFocused = it.isFocused
                        },
                    value = state.query,
                    onValueChange = { onEvent(CoinListEvent.ChangeValueQuery(it)) },
                    shape = CircleShape,
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.7f),
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent, cursorColor = Color.Black
                    ),
                    textStyle = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    ),
                    placeholder = {
                        Text(text = stringResource(id = R.string.place_holder_search))
                    },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        autoCorrect = false,
                        keyboardType = KeyboardType.Text, imeAction = ImeAction.Search
                    ), keyboardActions = KeyboardActions(onSearch = {
                        focusManager.clearFocus()

                    }), trailingIcon = {
                        if (isFocused || state.query.isNotBlank()) {
                            IconButton(onClick = {
                                focusManager.clearFocus()
                                onEvent(CoinListEvent.ChangeValueQuery(""))
                            }) {
                                Icon(
                                    modifier = Modifier.size(spacing.iconSize),
                                    imageVector = Icons.Default.Clear,
                                    contentDescription = null
                                )
                            }
                        }
                    }
                )

                Spacer(modifier = Modifier.height(spacing.spaceMicroSmall))
            }

            items(state.coinsList) { item: Coin ->

                CoinItem(item = item, onClick = { onEvent(CoinListEvent.OnClickCoin(item.id)) })

            }

        }

        CryptocurrencyDefaultLoading(isLoading = state.isLoading)

    }
}


@Preview
@Composable
fun CoinListContentPreview() {
    CoinListContent(state = CoinListState(), onEvent = {})
}

