import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("multiplatform") version "1.4.30"
    id("org.jetbrains.compose") version "0.3.1"
}

group = "cyan0fbcf9"
version = "1.0"

repositories {
    jcenter()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}


kotlin {
    jvm()

    sourceSets {
        val jvmMain by getting {
            dependencies {
                implementation(project(":common"))
                implementation(project(":nativeCommon"))
                implementation(compose.desktop.currentOs)

                val mviKotlinVersion = "2.0.0"
                val mviKotlinModuleList =
                    listOf("mvikotlin", "mvikotlin-main", "mvikotlin-extensions-coroutines")
                mviKotlinModuleList.forEach {
                    implementation("com.arkivanov.mvikotlin:${it}:${mviKotlinVersion}")
                }
                implementation(kotlin("stdlib-jdk8"))
            }
        }
    }
}

compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "compose"
            packageVersion = "1.0.0"

            windows {
                menuGroup = "QR Screenshot"
                upgradeUuid = "eb5544b4-2b0c-4b73-a54e-409ec4b358b1"
            }
        }
    }
}
