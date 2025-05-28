package se.sakana.utils

import androidx.core.graphics.PathParser

actual class CharacterParser {
    actual fun parse(pathData: String): List<CharacterOffset> {
        return buildList {
            val points = PathParser.createPathFromPathData(pathData)
                .approximate(0.5f)
                .toList()
                .chunked(3)

            for ((_, x, y) in points) {
                add(CharacterOffset(x, y))
            }
        }
    }
}