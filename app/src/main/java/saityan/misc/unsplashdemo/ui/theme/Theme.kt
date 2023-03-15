package saityan.misc.unsplashdemo.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorPalette = darkColors(
    primary = Blue,
    onPrimary = Color.White,
    primaryVariant = DeepBlue,

    secondary = Orange,
    onSecondary = DeepBlue,

    surface = DeepBlue,
    onSurface = Color.White,

    background = Color.Black,
    onBackground = Color.White,
)

@Composable
fun UnsplashDemoTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = DarkColorPalette
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(
        color = colors.secondary
    )

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
