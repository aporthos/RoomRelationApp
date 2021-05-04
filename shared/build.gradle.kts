import Dependencies.implementation
import Dependencies.kapt
import Dependencies.testImplementation

plugins {
    id ("com.android.library")
    kotlin ("android")
    kotlin ("kapt")
}

android {
    compileSdkVersion (AppConfig.compileSdk)
    buildToolsVersion (AppConfig.buildToolsVersion)

    defaultConfig {
        minSdkVersion (AppConfig.minSdk)
        targetSdkVersion (AppConfig.targetSdk)
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = AppConfig.androidTestInstrumentation
        consumerProguardFiles (AppConfig.proguardConsumerRules)
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles (getDefaultProguardFile("proguard-android-optimize.txt"), AppConfig.proguardConsumerRules)
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

dependencies {
    implementation(Dependencies.CORE)
    //Hilt
    implementation(Dependencies.HILT)
    kapt(Dependencies.HILT_KAPT)
    //Coroutines
    implementation(Dependencies.COROUTINES)
    //Room
    implementation(Dependencies.ROOM)
    kapt(Dependencies.ROOM_KAPT)
    //Timber
    implementation(Dependencies.TIMBER)
    testImplementation (Dependencies.JUNIT)
    //Lifecycle
    implementation(Dependencies.LIFECYCLE)
}