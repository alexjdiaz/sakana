package se.sakana.utils

expect class CharacterParser {
    fun parse(pathData: String): List<CharacterOffset>
}

data class CharacterOffset(
    val x: Float,
    val y: Float
)

data class CharacterStroke(
    val points: List<CharacterOffset>
)
