import Dependencies.implementation
import Dependencies.kapt
import Dependencies.testImplementation

plugins {
    id("com.android.application")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdkVersion(AppConfig.compileSdk)
    buildToolsVersion(AppConfig.buildToolsVersion)

    defaultConfig {
        applicationId = "com.globant.roomapplication"
        minSdkVersion(AppConfig.minSdk)
        targetSdkVersion(AppConfig.targetSdk)
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = AppConfig.androidTestInstrumentation
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                AppConfig.proguardConsumerRules
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(Dependencies.CORE)
    implementation(Dependencies.NAVIGATION)
    implementation(Dependencies.CONSTRAINT)
    //Room
    implementation(Dependencies.ROOM)
    kapt(Dependencies.ROOM_KAPT)
    //Coroutines
    implementation(Dependencies.COROUTINES)
    //Lifecycle
    implementation(Dependencies.LIFECYCLE)
    //Hilt
    implementation(Dependencies.HILT)
    kapt(Dependencies.HILT_KAPT)
    //Timber
    implementation(Dependencies.TIMBER)

    testImplementation(Dependencies.JUNIT)

    implementation(project(":shared"))
}