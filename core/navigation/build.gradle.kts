plugins {
    id("shopping-app.android.library.compose")
}

android {
    namespace = "com.danielriverolosa.core.navigation"
}

dependencies {
    implementation(project(":core:ui"))

    testImplementation(libs.junit4)
    androidTestImplementation(libs.androidx.test.core)
    androidTestImplementation(libs.androidx.test.ext)
    androidTestImplementation(libs.androidx.test.espresso.core)
    androidTestImplementation(libs.androidx.compose.ui.test)

    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.testManifest)
}