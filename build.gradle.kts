// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.3" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    id("com.android.library") version "8.1.3" apply false
    id("org.jetbrains.kotlin.plugin.serialization") version "1.6.21"
    id("com.google.devtools.ksp") version "1.9.0-1.0.13" apply false
}
buildscript {
    val nav_version by extra("2.6.0")

    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version")
    }
}