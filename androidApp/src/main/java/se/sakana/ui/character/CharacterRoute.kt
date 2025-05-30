package se.sakana.ui.character

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.compose.viewmodel.koinViewModel
import se.sakana.ui.character.composables.CharacterContent
import se.sakana.ui.character.composables.CharacterError
import se.sakana.ui.character.composables.CharacterLoading

@Composable
internal fun CharacterRoute(
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: CharacterViewModel = koinViewModel()
) {
    val viewState by viewModel.viewStateFlow.collectAsStateWithLifecycle()

    CharacterScreen(
        viewState = viewState,
        onBackPressed = onBackPressed,
        modifier = modifier,
    )
}

@Composable
internal fun CharacterScreen(
    viewState: CharacterViewState,
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier,
) {
    when (viewState) {
        CharacterViewState.Error -> {
            CharacterError(
                modifier = modifier
                    .fillMaxSize()
                    .wrapContentSize(align = Alignment.Center),
            )
        }

        CharacterViewState.Loading -> {
            CharacterLoading(
                modifier = modifier
                    .fillMaxSize()
                    .wrapContentSize(align = Alignment.Center),
            )
        }

        is CharacterViewState.Success -> {
            CharacterContent(
                character = viewState.character,
                onBackPressed = onBackPressed,
                modifier = modifier,
            )
        }
    }
}
