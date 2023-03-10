plugins {
    id("shopping-app.android.application")
    id("shopping-app.android.application.compose")
    id("shopping-app.android.hilt")
}

android {
    namespace = AppConfig.applicationId
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = AppConfig.applicationId
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = AppConfig.androidTestInstrumentation
    }

    buildTypes {
        val debug by getting {
            enableUnitTestCoverage = true
            enableAndroidTestCoverage = true
        }

        val release by getting {
            enableUnitTestCoverage = false
            enableAndroidTestCoverage = false
            isDebuggable = false
            proguardFiles(
                getDefaultProguardFile(AppConfig.proguardFile), AppConfig.proguardRules
            )
        }
    }
    packagingOptions {
        resources.excludes.add("/META-INF/{AL2.0,LGPL2.1}")
    }
}

dependencies {
    implementation(project(":core:ui"))

    implementation(libs.coil.kt)
    implementation(libs.coil.kt.svg)

    testImplementation(libs.junit4)
    androidTestImplementation(libs.androidx.test.core)
    androidTestImplementation(libs.androidx.test.ext)
    androidTestImplementation(libs.androidx.test.espresso.core)
    androidTestImplementation(libs.androidx.compose.ui.test)

    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.testManifest)
}