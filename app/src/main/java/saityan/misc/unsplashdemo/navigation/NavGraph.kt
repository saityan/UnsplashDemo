package saityan.misc.unsplashdemo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.paging.ExperimentalPagingApi
import coil.annotation.ExperimentalCoilApi
import saityan.misc.unsplashdemo.navigation.screens.home.HomeScreen
import saityan.misc.unsplashdemo.navigation.screens.search.SearchScreen

@ExperimentalCoilApi
@ExperimentalPagingApi
@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = ScreenList.Home.route
    ) {
        composable(route = ScreenList.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(route = ScreenList.Search.route) {
            SearchScreen(navController = navController)
        }
    }
}
