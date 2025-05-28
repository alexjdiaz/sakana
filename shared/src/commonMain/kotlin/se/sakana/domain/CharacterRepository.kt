package se.sakana.domain

import org.koin.core.annotation.Single
import se.sakana.model.Character

interface CharacterRepository {
    fun getAllHiragana(): List<Character.Hiragana>
    fun getAllKatakana(): List<Character.Katakana>
    fun getKanji(ids: List<String>): List<Character.Kanji>
}

@Single
class CharacterRepositoryImpl : CharacterRepository {
    override fun getAllHiragana(): List<Character.Hiragana> {
        return emptyList()
    }

    override fun getAllKatakana(): List<Character.Katakana> {
        return emptyList()
    }

    override fun getKanji(ids: List<String>): List<Character.Kanji> {
        return emptyList()
    }
}