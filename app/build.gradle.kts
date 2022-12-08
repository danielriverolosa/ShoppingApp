plugins {
    id(GradlePlugin.androidApplication)
    id(GradlePlugin.kotlinAndroid)
    id(GradlePlugin.kotlinKapt)
    id(GradlePlugin.hilt)
    id(GradlePlugin.kotlinParcelize)
    id(GradlePlugin.safeArgs)
}

android {
    namespace = AppConfig.applicationId
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = AppConfig.applicationId
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = AppConfig.androidTestInstrumentation
        vectorDrawables.useSupportLibrary = true
    }

    buildTypes {
        getByName(AppConfig.debugBuild) {
            enableUnitTestCoverage = true
            enableAndroidTestCoverage = true
        }

        getByName(AppConfig.releaseBuild) {
            enableUnitTestCoverage = false
            enableAndroidTestCoverage = false
            isDebuggable = false
            proguardFiles(
                getDefaultProguardFile(AppConfig.proguardFile), AppConfig.proguardRules
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Version.compose
    }
    packagingOptions {
        resources.excludes.add("/META-INF/{AL2.0,LGPL2.1}")
    }
}

dependencies {
    implementation(Dependency.coreKtx)
    implementation(Dependency.lifecycle)
    implementation(Dependency.activityCompose)
    implementation(Dependency.composeUi)
    implementation(Dependency.composePreview)
    implementation(Dependency.material)

    implementation(Dependency.hilt)
    kapt(Dependency.hiltCompiler)

    testImplementation(Dependency.junit)
    androidTestImplementation(Dependency.junitUi)
    androidTestImplementation(Dependency.espresso)
    androidTestImplementation(Dependency.composeUiTest)

    debugImplementation(Dependency.composeUiTooling)
    debugImplementation(Dependency.composeUiTestManifest)
}