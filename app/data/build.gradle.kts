plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_7
    targetCompatibility = JavaVersion.VERSION_1_7
}

dependencies {
    implementation("com.google.code.gson:gson:2.10.1")
    //retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    //converter
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
}