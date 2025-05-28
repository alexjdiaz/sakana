package se.sakana.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.koin.android.annotation.KoinViewModel
import se.sakana.domain.CharacterRepository
import se.sakana.model.Character

@KoinViewModel
class CharacterViewModel(
    repository: CharacterRepository,
) : ViewModel() {

    private val _characterStateFlow: MutableStateFlow<Character> =
        MutableStateFlow(previewCharacter)

    val characterStateFlow: StateFlow<Character> = _characterStateFlow

}

val previewCharacter = Character.Kanji(
    id = "0",
    strokes = emptyList(),
    components = emptyList(),
)
