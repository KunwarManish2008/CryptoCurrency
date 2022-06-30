package com.mandroid.cryptocurrency.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mandroid.cryptocurrency.presentation.coin_detail.CoinDetailScreen
import com.mandroid.cryptocurrency.presentation.coin_list.CoinListScreen
import com.mandroid.cryptocurrency.presentation.ui.theme.CryptocurrencyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptocurrencyTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {

                    val navController = rememberNavController()
                    Log.d("Main Activity", "$navController")
                    NavHost(navController = navController,
                            startDestination = Screen.CoinListScreen.route
                        ){
                        composable(
                            route = Screen.CoinListScreen.route
                        ){
                            Log.d("Main Activity", "route to list screen")
                            CoinListScreen(navController)
                        }
                        composable(
                            route = Screen.ConDetailScreen.route + "/{coinId}"
                        ){
                            CoinDetailScreen()
                        }
                    }

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CryptocurrencyTheme {

    }
}