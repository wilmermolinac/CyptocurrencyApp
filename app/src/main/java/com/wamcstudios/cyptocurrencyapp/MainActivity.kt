package com.wamcstudios.cyptocurrencyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.wamcstudios.cyptocurrencyapp.navigation.graph.RootNavGraph
import com.wamcstudios.cyptocurrencyapp.navigation.routes.NavigationRoute
import com.wamcstudios.cyptocurrencyapp.ui.theme.CyptocurrencyAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navHostController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            navHostController = rememberNavController()

            CyptocurrencyAppTheme {
                RootNavGraph(
                    navHostController = navHostController,
                    startDestination = NavigationRoute.CoinList
                )
            }
        }
    }
}
