package se.sakana.ui.character

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import se.sakana.domain.CharacterRepository
import se.sakana.model.CharacterRoot
import se.sakana.model.CharacterSettings

internal class CharacterViewModel(
    characterRepository: CharacterRepository,
) : ViewModel() {

    private val _viewStateFlow: MutableStateFlow<CharacterViewState> =
        MutableStateFlow(CharacterViewState.Loading)

    val viewStateFlow: StateFlow<CharacterViewState> = _viewStateFlow

    init {
        val character = characterRepository.getCharacter("04e8b")
        _viewStateFlow.value = CharacterViewState.Success(character)
    }

}

internal sealed class CharacterViewState {
    data class Success(
        val character: CharacterRoot,
        val characterSettings: CharacterSettings = CharacterSettings(),
    ) : CharacterViewState()

    data object Error : CharacterViewState()
    data object Loading : CharacterViewState()
}