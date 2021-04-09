import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.30"
}

group = "cyan0fbcf9"
version = "1.0"

dependencies {
    val zxingVersion = "3.4.1"
    implementation("com.google.zxing:core:${zxingVersion}")
    implementation("com.google.zxing:javase:${zxingVersion}")

    testImplementation(kotlin("test-junit"))
    testImplementation("com.google.truth:truth:1.1")

    val daggerVersion = "2.30.1"
    api("com.google.dagger:dagger:${daggerVersion}")
    annotationProcessor("com.google.dagger:dagger-compiler:${daggerVersion}")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.2")
    implementation(kotlin("stdlib-jdk8"))
}

tasks.test {
    useJUnit()
}

repositories {
    mavenCentral()
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
