package se.sakana.extensions

import androidx.compose.runtime.Composable
import dev.icerock.moko.resources.StringResource

@Composable
fun stringResource(res: StringResource): String =
    androidx.compose.ui.res.stringResource(res.resourceId)