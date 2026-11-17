
// ── Plugins ──────────────────────────────────────────────────
plugins {

    // ── Android Application Plugin ─────────────────────────
    alias(libs.plugins.android.application)

    // ── Kotlin Compose Plugin ──────────────────────────────
    alias(libs.plugins.kotlin.compose)
}


// ── Android Configuration ───────────────────────────────────
android {

    // ── Application Identity ───────────────────────────────
    namespace = "com.bandaedge"

    // ── SDK Configuration ──────────────────────────────────
    compileSdk {
        version = release(37)
    }

    // ── Default Configuration ─────────────────────────────
    defaultConfig {
        applicationId = "com.bandaedge"

        minSdk = 26
        targetSdk = 36

        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner =
            "androidx.test.runner.AndroidJUnitRunner"
    }

    // ── Build Types ────────────────────────────────────────
    buildTypes {
        release {
            isMinifyEnabled = false

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    // ── Java Compatibility ─────────────────────────────────
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    // ── Build Features ─────────────────────────────────────
    buildFeatures {
        compose = true
    }
}


// ── Dependencies ────────────────────────────────────────────
dependencies {

    // ── AndroidX Core ──────────────────────────────────────
    implementation(libs.androidx.core.ktx)

    // ── Android Activity ────────────────────────────────────
    implementation(libs.androidx.activity.compose)

    // ── Lifecycle ──────────────────────────────────────────
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidxLifecycleViewmodelCompose)
    implementation(libs.androidxLifecycleViewmodelKtx)

    // ── Kotlin Coroutines ──────────────────────────────────
    implementation(libs.kotlinxCoroutinesAndroid)

    // ── Compose BOM ────────────────────────────────────────
    implementation(platform(libs.androidx.compose.bom))

    // ── Compose UI ─────────────────────────────────────────
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)

    // ── Material Design ────────────────────────────────────
    implementation(libs.androidx.compose.material3)

    // ── Unit Testing ──────────────────────────────────────
    testImplementation(libs.junit)

    // ── Instrumented Testing ───────────────────────────────
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)

    // ── Debug Tools ────────────────────────────────────────
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
}
