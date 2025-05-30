package se.sakana.ui.character.composables

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
internal fun CharacterLoading(
    modifier: Modifier = Modifier
) {
    CircularProgressIndicator(
        modifier = modifier,
    )
}