object Dependencies {

    val coreKtx by lazy {
        "androidx.core:core-ktx:${Versions.coreKtx}"
    }
    val appcompat by lazy {
        "androidx.appcompat:appcompat:${Versions.appCompat}"
    }
    val material by lazy {
        "com.google.android.material:material:${Versions.material}"
    }
    val lifestyleRuntimeKtx by lazy {
        "androidx.lifecycle:lifecycle-runtime-ktx:2.6.2"
    }
    val activityCompose by lazy {
        "androidx.activity:activity-compose:${Versions.activityCompose}"
    }
    val composeBom by lazy {
        "androidx.compose:compose-bom:${Versions.composeBom}"
    }
    val composeUI by lazy {
        "androidx.compose.ui:ui"
    }
    val composeUiGraphics by lazy {
        "androidx.compose.ui:ui-graphics"
    }
    val composeUiToolingPreview by lazy {
        "androidx.compose.ui:ui-tooling-preview"
    }
    val composeMaterial by lazy {
        "androidx.compose.material3:material3"
    }

    val junit by lazy {
        "junit:junit:${Versions.junit}"
    }
    val testJunit by lazy {
        "androidx.test.ext:junit:${Versions.testJunit}"
    }
    val testEspresso by lazy {
        "androidx.test.espresso:espresso-core:${Versions.testEspresso}"
    }
    val testUIJunit by lazy {
        "androidx.compose.ui:ui-test-junit4"
    }
    val composeUITooling by lazy {
        "androidx.compose.ui:ui-tooling"
    }
    val composeUITestManifest by lazy {
        "androidx.compose.ui:ui-test-manifest"
    }

    val hiltAndroid by lazy {
        "com.google.dagger:hilt-android:${Versions.hilt}"
    }
    val hiltAndroidCompiler by lazy {
        "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    }
    val hiltCompiler by lazy {
        "androidx.hilt:hilt-compiler:${Versions.hiltCompiler}"
    }
    val hiltNavigationCompose by lazy {
        "androidx.hilt:hilt-navigation-compose:${Versions.hiltNavigationCompose}"
    }
    val retrofit by lazy {
        "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    }
    val okhttp by lazy {
        "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    }
    val gsonConverter by lazy {
        "com.squareup.retrofit2:converter-gson:${Versions.gsonConverter}"
    }
    val moshi by lazy {
        "com.squareup.moshi:moshi-kotlin:${Versions.moshi}"
    }
    val moshiConverter by lazy {
        "com.squareup.retrofit2:converter-moshi:${Versions.moshiConverter}"
    }
    val loggingInterceptor by lazy {
        "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}"
    }
    val coroutineCore by lazy {
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    }
    val coroutineAndroid by lazy {
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    }
    val navigationCompose by lazy {
        "androidx.navigation:navigation-compose:${Versions.navigationCompose}"
    }
    val splashScreen by lazy {
        "androidx.core:core-splashscreen:${Versions.splashScreen}"
    }
    val coil by lazy {
        "io.coil-kt:coil-compose:${Versions.coil}"
    }


}

object Modules {
    const val utilities = ":utilities"
}