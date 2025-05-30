package se.sakana.extensions

import androidx.compose.ui.geometry.Rect

fun List<Rect>.getTotalBounds() = reduce { acc, rect ->
    Rect(
        left = minOf(acc.left, rect.left),
        top = minOf(acc.top, rect.top),
        right = maxOf(acc.right, rect.right),
        bottom = maxOf(acc.bottom, rect.bottom)
    )
}