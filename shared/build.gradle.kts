import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.serialization)
    alias(libs.plugins.multiplatform.resources)
    alias(libs.plugins.ksp)
}

kotlin {
    androidTarget {
        compilations.all {
            compileTaskProvider.configure {
                compilerOptions.jvmTarget = JvmTarget.JVM_1_8
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "shared"
            isStatic = true
            export(libs.moko.resources)
        }
    }

    compilerOptions {
        freeCompilerArgs.add("-Xexpect-actual-classes")
    }

    sourceSets {
        commonMain.dependencies {
            implementation(libs.bundles.koin.shared)
            implementation(libs.moko.resources)
            implementation(libs.xmlutil.core)
            implementation(project.dependencies.platform(libs.koin.annotations.bom))
            implementation(project.dependencies.platform(libs.koin.bom))
        }

        androidMain.dependencies {
            implementation(libs.androidx.core)
        }
    }
}

android {
    namespace = "se.sakana"
    compileSdk = 35
    defaultConfig {
        minSdk = 26
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    add("kspCommonMainMetadata", libs.koin.annotations.ksp.compiler)
    add("kspAndroid", libs.koin.annotations.ksp.compiler)
    add("kspIosX64", libs.koin.annotations.ksp.compiler)
    add("kspIosArm64", libs.koin.annotations.ksp.compiler)
    add("kspIosSimulatorArm64", libs.koin.annotations.ksp.compiler)
}

ksp {
    arg("KOIN_CONFIG_CHECK", "true")
}

multiplatformResources {
    resourcesPackage = "se.sakana"
    resourcesClassName = "SakanaResources"
}