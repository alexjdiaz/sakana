package se.sakana.navigation

import kotlinx.serialization.Serializable

sealed class SakanaRoute {
    @Serializable
    data object Character : SakanaRoute()
}