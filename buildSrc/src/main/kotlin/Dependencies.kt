import org.gradle.api.artifacts.dsl.DependencyHandler

object Dependencies {
    val CORE = listOf(
        "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}",
        "androidx.core:core-ktx:${Versions.core}",
        "androidx.appcompat:appcompat:${Versions.appCompat}",
        "com.google.android.material:material:${Versions.material}"
    )

    val CONSTRAINT = listOf(
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    )

    val NAVIGATION = listOf(
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}",
        "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    )

    val HILT = listOf(
        "com.google.dagger:hilt-android:${Versions.hilt}",
        "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hiltViewModel}"
    )

    val HILT_KAPT = listOf(
        "com.google.dagger:hilt-android-compiler:${Versions.hilt}",
        "androidx.hilt:hilt-compiler:${Versions.hiltViewModel}"
    )


    val ROOM = listOf(
        "androidx.room:room-runtime:${Versions.room}",
        "androidx.room:room-ktx:${Versions.room}"
    )

    val ROOM_KAPT = listOf(
        "androidx.room:room-compiler:${Versions.room}"
    )

    val COROUTINES = listOf(
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}",
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    )

    val LIFECYCLE = listOf(
        "androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0",
        "androidx.lifecycle:lifecycle-runtime-ktx:2.2.0"
    )

    val TIMBER = listOf(
        "com.jakewharton.timber:timber:${Versions.timber}"
    )

    val JUNIT = listOf(
        "junit:junit:${Versions.junit}"
    )


    fun DependencyHandler.kapt(list: List<String>) {
        list.forEach { dependency ->
            add("kapt", dependency)
        }
    }

    fun DependencyHandler.implementation(list: List<String>) {
        list.forEach { dependency ->
            add("implementation", dependency)
        }
    }

    fun DependencyHandler.testImplementation(list: List<String>) {
        list.forEach { dependency ->
            add("testImplementation", dependency)
        }
    }
}