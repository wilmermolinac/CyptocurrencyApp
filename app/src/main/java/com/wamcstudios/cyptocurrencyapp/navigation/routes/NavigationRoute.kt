package com.wamcstudios.cyptocurrencyapp.navigation.routes

sealed class NavigationRoute(val route: String) {

    object CoinList : NavigationRoute(route = "coin_list")
    object CoinDetail : NavigationRoute(route = "coin_list/detail/?{coinId}") {
        fun passData(coinId: String) = "coin_list/detail/?$coinId"
    }
}