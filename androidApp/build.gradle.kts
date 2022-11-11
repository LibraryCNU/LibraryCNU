plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.collathon.librarycnu.android"
    compileSdk = 32
    defaultConfig {
        applicationId = "com.collathon.librarycnu.android"
        minSdk = 21
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.0"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

val koin_android_version= "3.3.0"

dependencies {
    implementation(project(":shared"))
    implementation("io.insert-koin:koin-android:$koin_android_version")
    implementation("androidx.compose.ui:ui:1.2.1")
    implementation("androidx.compose.ui:ui-tooling:1.2.1")
    implementation("androidx.compose.ui:ui-tooling-preview:1.2.1")
    implementation("androidx.compose.foundation:foundation:1.2.1")
    implementation("androidx.compose.material:material:1.2.1")
    implementation("androidx.activity:activity-compose:1.5.1")
    implementation("androidx.navigation:navigation-compose:2.5.3")
    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.2.0")
}