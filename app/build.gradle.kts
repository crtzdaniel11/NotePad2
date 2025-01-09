plugins {
    id("com.android.application") // Correct plugin for Android projects
    kotlin("android") // Kotlin plugin for Android
    kotlin("kapt") // Kotlin Annotation Processing plugin (if needed)
}


android {
    namespace = "com.example.notepadapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.notepadapp"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        compose = true // Enable Jetpack Compose
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.6.0"
    }

    kotlinOptions {
        jvmTarget = "17" // Ensure compatibility
    }

    kapt {
        correctErrorTypes = true
    }
}


dependencies {
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.compose.ui:ui:1.6.0")
    implementation("androidx.compose.material3:material3:1.1.0")
}
