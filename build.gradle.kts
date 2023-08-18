// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.0" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
    id("org.jetbrains.kotlin.jvm") version "1.8.10" apply false

    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin") version "2.0.1" apply false

    id ("org.jetbrains.kotlin.plugin.lombok") version "1.8.10"
    id ("io.freefair.lombok") version "8.1.0"

    id("com.google.devtools.ksp") version "1.8.10-1.0.9" apply false
}