plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.serialization)
    alias(libs.plugins.ksp)
}

android {
    namespace = "se.sakana.android"
    compileSdk = 36

    defaultConfig {
        applicationId = "se.sakana.android"
        minSdk = 26
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        compose = true
    }

    packaging {
        resources.excludes += "/META-INF/{AL2.0,LGPL2.1}"
    }

    buildTypes {
        getByName("release") { isMinifyEnabled = false }
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

}

dependencies {
    debugImplementation(libs.androidx.compose.ui.tooling)
    implementation(libs.bundles.compose)
    implementation(libs.bundles.koin.compose)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.moko.resources)
    implementation(project.dependencies.platform(libs.koin.bom))
    implementation(projects.shared)
}

ksp {
    arg("KOIN_CONFIG_CHECK", "true")
}
