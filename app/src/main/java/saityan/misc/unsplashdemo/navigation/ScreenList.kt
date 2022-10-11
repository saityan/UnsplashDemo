package saityan.misc.unsplashdemo.navigation

sealed class ScreenList(val route: String) {
    object Home : ScreenList("home_screen")
    object Search : ScreenList("search_screen")
}
