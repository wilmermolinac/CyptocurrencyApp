package com.wamcstudios.cyptocurrencyapp.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.wamcstudios.aifusion.navigation.utils.navigate
import com.wamcstudios.cyptocurrencyapp.navigation.routes.NavigationRoute
import com.wamcstudios.cyptocurrencyapp.presentation.coin_detail.CoinDetailScreen
import com.wamcstudios.cyptocurrencyapp.presentation.coin_list.CoinListScreen

@Composable
fun RootNavGraph(navHostController: NavHostController, startDestination: NavigationRoute) {

    NavHost(navController = navHostController, startDestination = startDestination.route) {

        composable(route = NavigationRoute.CoinList.route) {
            CoinListScreen(onNavigate = navHostController::navigate)
        }

        composable(
            route = NavigationRoute.CoinDetail.route,
            arguments = listOf(navArgument(name = "coinId") {
                type = NavType.StringType
                nullable = true
                defaultValue = null

            })
        ) {

            val coinId = it.arguments?.getString("coinId")

            CoinDetailScreen(onNavigate = navHostController::navigate)

        }
    }
}