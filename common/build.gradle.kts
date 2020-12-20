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
}

tasks.test {
    useJUnit()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}