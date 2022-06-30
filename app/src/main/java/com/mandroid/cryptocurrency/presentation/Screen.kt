package com.mandroid.cryptocurrency.presentation

/**
 * Created by Manish Kumar on 29/06/22.
 */
sealed class Screen(val route: String){
    object CoinListScreen: Screen("coin_list_screen")
    object ConDetailScreen: Screen("coin_detail_screen")
}
