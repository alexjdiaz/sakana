plugins {
    alias(libs.plugins.android.application).apply(false)
    alias(libs.plugins.android.library).apply(false)
    alias(libs.plugins.compose.compiler).apply(false)
    alias(libs.plugins.kotlin.android).apply(false)
    alias(libs.plugins.kotlin.multiplatform).apply(false)
    alias(libs.plugins.ksp).apply(false)
    alias(libs.plugins.multiplatform.resources).apply(false)
    alias(libs.plugins.serialization).apply(false)
}

buildscript {
    dependencies {
        classpath(libs.moko.resources.generator)
    }
}
