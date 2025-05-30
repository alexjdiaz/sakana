package se.sakana.extensions

import androidx.compose.runtime.compositionLocalOf
import se.sakana.model.CharacterSettings

val LocalCharacterSettings = compositionLocalOf {
    CharacterSettings()
}
