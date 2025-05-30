package se.sakana.model

import dev.icerock.moko.graphics.Color

data class CharacterRoot(
    val id: String,
    val text: String,
    val components: List<CharacterComponent>,
)

data class CharacterComponent(
    val id: String,
    val text: String,
    val color: Color,
    val strokes: List<String>,
    val original: CharacterRoot? = null,
)