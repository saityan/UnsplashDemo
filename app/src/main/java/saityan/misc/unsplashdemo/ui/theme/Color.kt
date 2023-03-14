package saityan.misc.unsplashdemo.ui.theme

import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Orange = Color(0xFFC77D0D)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)
val HeartRed = Color(0xFFFF4444)

val Colors.topAppBarContentColor: Color
    get() = if (isLight) Color.White else Color.LightGray

val Colors.topAppBarBackgroundColor: Color
    get() = if (isLight) Orange else Color.Black

val Colors.windowBackground: Color
    get() = if (isLight) Color.White else Color.Black
