plugins {
    id("shopping-app.android.library")
    id("shopping-app.android.hilt")
    id("kotlinx-serialization")
}

android {
    namespace = "com.danielriverolosa.core.data"

    defaultConfig {
        buildConfigField("String", "BASE_URL", "\"https://fakestoreapi.com/\"")
    }
}

dependencies {
    implementation(project(":core:domain"))

    implementation(libs.kotlinx.serialization.json)
    implementation(libs.kotlinx.datetime)

    implementation(libs.okhttp.logging)
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.kotlin.serialization)
}