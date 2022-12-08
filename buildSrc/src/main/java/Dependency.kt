object Dependency {

    // Kotlin
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib:${Version.kotlin}"

    // Background tasks
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.coroutines}"

    // DI
    const val hilt = "com.google.dagger:hilt-android:${Version.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Version.hilt}"
    const val javaInject = "javax.inject:javax.inject:${Version.javaInject}"

    // Framework
    const val coreKtx = "androidx.core:core-ktx:${Version.coreKtx}"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Version.navigation}"
    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.lifecycle}"
    const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.lifecycle}"
    const val crypto = "androidx.security:security-crypto:${Version.crypto}"
    const val timber = "com.jakewharton.timber:timber:${Version.timber}"

    // Design
    const val material = "androidx.compose.material3:material3:${Version.material}"
    const val coil = "io.coil-kt:coil:${Version.coil}"
    const val composeUi = "androidx.compose.ui:ui:${Version.compose}"
    const val composePreview = "androidx.compose.ui:ui-tooling-preview:${Version.compose}"
    const val activityCompose = "androidx.activity:activity-compose:${Version.activityCompose}"
    const val composeUiTooling = "androidx.compose.ui:ui-tooling:${Version.compose}"
    const val composeUiTestManifest = "androidx.compose.ui:ui-test-manifest:${Version.compose}"

    // Network
    const val okHttp = "com.squareup.okhttp3:logging-interceptor:${Version.okHttp}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
    const val moshiConverter = "com.squareup.retrofit2:converter-moshi:${Version.retrofit}"

    // Local data storage
    const val roomRuntime = "androidx.room:room-runtime:${Version.room}"
    const val roomKtx = "androidx.room:room-ktx:${Version.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Version.room}"

    // Unit Testing
    const val junit = "junit:junit:${Version.junit}"
    const val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Version.coroutines}"
    const val androidXTest = "androidx.test:core:${Version.androidXTest}"
    const val turbine = "app.cash.turbine:turbine:${Version.turbine}"
    const val mockk = "io.mockk:mockk:${Version.mockk}"
    const val koTest = "io.kotest:kotest-assertions-core:${Version.koTest}"
    const val roomTest = "androidx.room:room-testing:${Version.room}"

    // Android UI Testing
    const val junitUi = "androidx.test.ext:junit:${Version.junitUi}"
    const val composeUiTest = "androidx.compose.ui:ui-test-junit4:${Version.compose}"
    const val espresso = "androidx.test.espresso:espresso-core:${Version.espresso}"
}