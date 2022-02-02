plugins {
    id("com.android.application")
    kotlin("android")
    id ("kotlin-kapt")
    id ("dagger.hilt.android.plugin")
//    id ("com.google.gms.google-services")
}
group = "ru.alira"
version = "1.0-SNAPSHOT"

repositories {
    gradlePluginPortal()
    google()
    mavenCentral()
}
//val composeVersion = findProperty("version.compose") as String
dependencies {
    implementation(project(":core-android-ui-kit"))
    implementation(project(":shared"))
    implementation("androidx.appcompat:appcompat:1.4.1")
    implementation("com.google.android.material:material:1.5.0")

    val composeVersion = "1.2.0-alpha01"
    val activityComposeVersion = "1.4.0"
    implementation("androidx.activity:activity-compose:$activityComposeVersion")

    implementation("androidx.compose.compiler:compiler:$composeVersion")
    implementation("androidx.compose.foundation:foundation:$composeVersion")
    implementation("androidx.compose.ui:ui:$composeVersion")
    implementation("androidx.compose.material:material:$composeVersion")
    implementation("androidx.navigation:navigation-compose:2.5.0-alpha01")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")

    // Hilt
    implementation("com.google.dagger:hilt-android:2.40.5")
    kapt("com.google.dagger:hilt-android-compiler:2.40.5")

//    implementation(project(":shared"))
//    implementation(project(":feature-login-android"))
//    implementation("com.google.android.material:material:1.4.0")
//
//    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
//
//    implementation("androidx.compose.ui:ui:$composeVersion")
//    implementation("androidx.compose.ui:ui-tooling:$composeVersion")
//    implementation("androidx.compose.foundation:foundation:$composeVersion")
//    implementation("androidx.compose.material:material:$composeVersion")
//    implementation("androidx.navigation:navigation-compose:2.4.0-rc01")
//    // Coroutines
//    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9")
////    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0")
//    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.2.0")
//    // Hilt
//    implementation("com.google.dagger:hilt-android:2.38.1")
//    kapt("com.google.dagger:hilt-compiler:2.38.1")
}

android {
    compileSdk = 31
    defaultConfig {
        applicationId = "ru.alira.pets.stg"
        minSdk = 24
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.2.0-alpha01"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}