package se.sakana.model

data class Word(
    val text: String,
    val components: List<CharacterRoot>,
)