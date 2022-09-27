plugins {
    id("com.android.application")
    id("kotlin-android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = Apps.compileSdk
    defaultConfig {
        applicationId = "com.example.sunflowersample"
        minSdk = Apps.minSdk
        targetSdk = Apps.targetSdk
        versionCode = Apps.versionCode
        versionName = Apps.versionName
        testInstrumentationRunner = Apps.androidTestInstrumentation
    }
    buildFeatures {
        dataBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    // std libs
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    // kapts
    kapt(Kapts.list)
    // app libs
    implementation(Libs.appLibraries)
    // test libs
    testImplementation(Libs.testLibraries)
    androidTestImplementation(Libs.androidTestLibraries)
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}