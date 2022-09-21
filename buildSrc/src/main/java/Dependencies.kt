import org.gradle.api.artifacts.dsl.DependencyHandler

object Apps {
    const val compileSdk = 32
    const val minSdk = 29
    const val targetSdk = 32
    const val versionCode = 1
    const val versionName = "1.0.0"

    const val androidTestInstrumentation = "androidx.test.runner.AndroidJUnitRunner"
}

object Versions {
    const val gradle = "7.2.1"
    const val kotlin = "1.7.10"
    const val coreKtx = "1.2.0"
    const val appcompat = "1.5.1"
    const val constraintLayout = "2.0.0-beta8"
    const val material = "1.6.0-rc01"
    const val navigation = "2.5.2"
    const val hilt = "2.38.1"

    const val junit = "4.12"
    const val extJunit = "1.1.1"
    const val espresso = "3.2.0"
}

object Libs {
    //
    private const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    private const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    private const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    private const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    private const val material = "com.google.android.material:material:${Versions.material}"
    private const val navigationRuntime = "androidx.navigation:navigation-runtime-ktx:${Versions.navigation}"
    private const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    private const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    private const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"

    // Test
    private const val junit = "junit:junit:${Versions.junit}"
    private const val extJUnit = "androidx.test.ext:junit:${Versions.extJunit}"
    private const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"


    val appLibraries = arrayListOf<String>().apply {
        add(kotlin)
        add(coreKtx)
        add(appcompat)
        add(constraintLayout)
        add(material)
        add(navigationRuntime)
        add(navigationFragment)
        add(navigationUi)
        add(hilt)
    }

    val androidTestLibraries = arrayListOf<String>().apply {
        add(extJUnit)
        add(espressoCore)
    }

    val testLibraries = arrayListOf<String>().apply {
        add(junit)
    }

}

object Kapts {
    private const val hilt = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"

    val list  = arrayListOf<String>().apply {
        add(hilt)
    }
}

// util functions for adding the differnt type dependencies from build.gradle file
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

fun DependencyHandler.androidTestImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("androidTestImplementation", dependency)
    }
}

fun DependencyHandler.testImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("testImplementation", dependency)
    }
}
