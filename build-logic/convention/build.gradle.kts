plugins {
    `kotlin-dsl`
}

group = "com.danielriverolosa.shoppingapp.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}


gradlePlugin {
    plugins {
        register("applicationCompose") {
            id = "shopping-app.android.application.compose"
            implementationClass = "ApplicationComposePlugin"
        }
        register("application") {
            id = "shopping-app.android.application"
            implementationClass = "ApplicationPlugin"
        }
        register("libraryCompose") {
            id = "shopping-app.android.library.compose"
            implementationClass = "LibraryComposePlugin"
        }
        register("library") {
            id = "shopping-app.android.library"
            implementationClass = "LibraryPlugin"
        }
        register("feature") {
            id = "shopping-app.android.feature"
            implementationClass = "FeaturePlugin"
        }
        register("androidTest") {
            id = "shopping-app.android.test"
            implementationClass = "AndroidTestPlugin"
        }
        register("hilt") {
            id = "shopping-app.android.hilt"
            implementationClass = "HiltPlugin"
        }
    }
}