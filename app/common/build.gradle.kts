plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")

    id("com.google.devtools.ksp")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies{

    implementation(project(mapOf("path" to ":app:data")))
    implementation(project(mapOf("path" to ":app:repository")))

}