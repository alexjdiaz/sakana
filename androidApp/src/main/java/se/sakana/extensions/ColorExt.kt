package se.sakana.extensions

import androidx.compose.ui.graphics.Color
import kotlin.math.roundToInt

val dev.icerock.moko.graphics.Color.asComposeColor: Color
    get() = Color(
        red = red.toFloat(),
        green = green.toFloat(),
        blue = blue.toFloat(),
        alpha = alpha.toFloat()
    )

val Color.asMokoColor: dev.icerock.moko.graphics.Color
    get() = dev.icerock.moko.graphics.Color(
        red = (red * 255f).roundToInt(),
        green = (green * 255f).roundToInt(),
        blue = (blue * 255f).roundToInt(),
        alpha = (alpha * 255f).roundToInt(),
    )