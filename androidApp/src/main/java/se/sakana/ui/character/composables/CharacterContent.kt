package se.sakana.ui.character.composables

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.graphics.vector.PathParser
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import se.sakana.SakanaResources
import se.sakana.domain.PreviewCharacter
import se.sakana.extensions.LocalCharacterSettings
import se.sakana.extensions.LocalPathParser
import se.sakana.extensions.asComposeColor
import se.sakana.extensions.stringResource
import se.sakana.model.CharacterComponent
import se.sakana.model.CharacterRoot
import se.sakana.model.CharacterSettings
import se.sakana.theme.SakanaTheme

@Composable
@OptIn(ExperimentalMaterial3Api::class)
internal fun CharacterContent(
    character: CharacterRoot,
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = character.text,
                        style = MaterialTheme.typography.headlineMedium,
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBackPressed) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = stringResource(SakanaResources.strings.general_action_back),
                        )
                    }
                },
            )
        },
        modifier = modifier,
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .wrapContentSize(BiasAlignment(0f, -0.5f)),
        ) {
            with(LocalDensity.current) {
                CharacterRoot(character = character)
            }
        }
    }
}

@Composable
private fun Density.CharacterRoot(
    character: CharacterRoot,
    modifier: Modifier = Modifier,
    settings: CharacterSettings = LocalCharacterSettings.current,
    pathParser: PathParser = LocalPathParser.current
) {
    val parent = character.components.joinToString { it.strokes.joinToString() }
    val bounds = pathParser.parsePathString(parent).toPath().getBounds()
    val size = bounds.size.toDpSize() * settings.characterSizeMultiplier

    Box(modifier = modifier.size(size)) {
        for (component in character.components) {
            CharacterComponent(
                component = component,
                bounds = bounds,
            )
        }
    }
}

@Composable
private fun CharacterComponent(
    component: CharacterComponent,
    bounds: Rect,
    modifier: Modifier = Modifier,
    settings: CharacterSettings = LocalCharacterSettings.current,
    pathParser: PathParser = LocalPathParser.current
) {
    val strokes = component.strokes.joinToString()
    val path = pathParser.parsePathString(strokes).toPath()

    Canvas(modifier = modifier.scale(settings.characterSizeMultiplier)) {
        translate(-bounds.left, -bounds.top) {
            drawPath(
                path = path,
                color = component.color.asComposeColor,
                style = Stroke(width = settings.strokeWidthDp.dp.toPx()),
            )
        }
    }
}

@Preview
@Composable
private fun Preview_CharacterContent() {
    SakanaTheme {
        CharacterContent(
            character = PreviewCharacter,
            onBackPressed = {},
            modifier = Modifier.fillMaxSize(),
        )
    }
}