
plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
    id("org.jetbrains.kotlin.plugin.lombok")
    id ("io.freefair.lombok")

    id("com.google.devtools.ksp")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_7
    targetCompatibility = JavaVersion.VERSION_1_7
}

dependencies{
    implementation(project(mapOf("path" to ":app:data")))
    implementation("org.mapstruct:mapstruct:1.5.5.Final")
    implementation(project(mapOf("path" to ":app:common")))
    ksp("org.mapstruct:mapstruct-processor:1.5.5.Final")
}