plugins {
    id("shopping-app.android.library.compose")
}

android {
    namespace = "com.danielriverolosa.core.ui"
}

dependencies {
    implementation(project(":core:domain"))

    api(libs.androidx.activity.compose)
    api(libs.androidx.core.ktx)
    api(libs.androidx.compose.runtime)
    api(libs.androidx.lifecycle.runtimeCompose)
    api(libs.androidx.compose.material3)
    api(libs.androidx.compose.material3.windowSizeClass)
    api(libs.androidx.hilt.navigation.compose)
    api(libs.androidx.navigation.compose)
    api(libs.androidx.window.manager)

    testImplementation(libs.junit4)
    androidTestImplementation(libs.androidx.test.core)
    androidTestImplementation(libs.androidx.test.ext)
    androidTestImplementation(libs.androidx.test.espresso.core)
    androidTestImplementation(libs.androidx.compose.ui.test)

    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.testManifest)
}