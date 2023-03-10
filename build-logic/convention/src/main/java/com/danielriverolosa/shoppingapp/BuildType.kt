package com.danielriverolosa.shoppingapp

enum class BuildType(val applicationIdSuffix: String? = null) {
    DEBUG(".debug"),
    RELEASE
}