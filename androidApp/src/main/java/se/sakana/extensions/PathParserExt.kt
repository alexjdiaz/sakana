package se.sakana.extensions

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.vector.PathParser

val LocalPathParser = compositionLocalOf { PathParser() }
