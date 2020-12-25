import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.20"
}

group = "cyan0fbcf9"
version = "1.0"

dependencies {
    val zxingVersion = "3.4.1"
    implementation("com.google.zxing:core:${zxingVersion}")
    implementation("com.google.zxing:javase:${zxingVersion}")

    testImplementation(kotlin("test-junit"))

    val daggerVersion = "2.30.1"
    api("com.google.dagger:dagger:${daggerVersion}")
    annotationProcessor("com.google.dagger:dagger-compiler:${daggerVersion}")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.2")
}

tasks.test {
    useJUnit()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}