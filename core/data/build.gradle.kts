plugins {
    id("shopping-app.android.library")
    id("shopping-app.android.hilt")
    id("kotlinx-serialization")
}

android {
    namespace = "com.danielriverolosa.core.data"
}

dependencies {
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.kotlinx.datetime)

    implementation(libs.okhttp.logging)
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.kotlin.serialization)
}