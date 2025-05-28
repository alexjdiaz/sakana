package se.sakana.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.compose.viewmodel.koinViewModel
import se.sakana.SakanaResources.strings
import se.sakana.ext.stringResource
import se.sakana.model.Character
import se.sakana.theme.SakanaTheme

@Composable
internal fun CharacterScreen(
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: CharacterViewModel = koinViewModel()
) {
    val character by viewModel.characterStateFlow.collectAsStateWithLifecycle()

    SakanaContent(
        character = character,
        onBackPressed = onBackPressed,
        modifier = modifier,
    )
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun SakanaContent(
    character: Character,
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(onClick = onBackPressed) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = stringResource(strings.general_action_back),
                        )
                    }
                },
            )
        },
        modifier = modifier,
    ) { paddingValues ->
        val primaryColor = MaterialTheme.colorScheme.primary

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
        ) {
            Canvas(
                modifier = Modifier
                    .fillMaxSize()
            ) {

                for (stroke in character.strokes) {
                    drawPoints(
                        points = stroke.points.map { point -> Offset(point.x, point.y) },
                        pointMode = PointMode.Points,
                        color = primaryColor
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun Preview_SakanaContent() {
    SakanaTheme {
        SakanaContent(
            character = previewCharacter,
            onBackPressed = {},
        )
    }
}