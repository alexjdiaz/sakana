package se.sakana.model

import se.sakana.utils.CharacterStroke

sealed class Character(
    open val id: String,
    open val unicode: String,
    open val strokes: List<CharacterStroke>,
) {
    data class Radical(
        override val id: String,
        override val unicode: String,
        override val strokes: List<CharacterStroke>,
    ) : Character(id, unicode, strokes)

    data class Kanji(
        override val id: String,
        override val unicode: String,
        override val strokes: List<CharacterStroke>,
        val components: List<Character>,
        val original: String? = null,
    ) : Character(id, unicode, strokes)

    data class Hiragana(
        override val id: String,
        override val unicode: String,
        override val strokes: List<CharacterStroke>,
    ) : Character(id, unicode, strokes)

    data class Katakana(
        override val id: String,
        override val unicode: String,
        override val strokes: List<CharacterStroke>,
    ) : Character(id, unicode, strokes)
}

