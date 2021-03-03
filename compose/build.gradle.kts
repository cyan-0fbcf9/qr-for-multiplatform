import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.20"
    id("org.jetbrains.compose") version "0.2.0-build132"
}

group = "cyan0fbcf9"
version = "1.0"

repositories {
    jcenter()
    maven { url = uri("https://maven.pkg.jetbrains.space/public/p/compose/dev") }
}

dependencies {
    implementation(project(":common"))
    implementation(compose.desktop.currentOs)

    val daggerVersion = "2.30.1"
    api("com.google.dagger:dagger:${daggerVersion}")
    annotationProcessor("com.google.dagger:dagger-compiler:${daggerVersion}")

    val mviKotlinVersion = "2.0.0"
    val mviKotlinModuleList =
        listOf("mvikotlin", "mvikotlin-main", "mvikotlin-extensions-coroutines")
    mviKotlinModuleList.forEach {
        implementation("com.arkivanov.mvikotlin:${it}:${mviKotlinVersion}")
    }
    implementation(kotlin("stdlib-jdk8"))
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "11"
}

compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "compose"
        }
    }
}
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}