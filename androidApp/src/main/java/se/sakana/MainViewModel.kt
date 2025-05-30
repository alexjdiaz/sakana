package se.sakana

import androidx.lifecycle.ViewModel
import se.sakana.model.CharacterSettings

internal class MainViewModel : ViewModel() {
    val settings: CharacterSettings
        get() = CharacterSettings()
}