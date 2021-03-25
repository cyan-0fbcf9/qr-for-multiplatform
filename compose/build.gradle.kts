import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("multiplatform") version "1.4.20"
    id("org.jetbrains.compose") version "0.2.0-build132"
}

group = "cyan0fbcf9"
version = "1.0"

repositories {
    jcenter()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}


kotlin {
    jvm()

    sourceSets {
        val jvmMain by getting {
            dependencies {
                implementation(compose.desktop.currentOs)
                implementation(project(":common"))
                implementation(project(":nativeCommon"))
                implementation(compose.desktop.currentOs)

                val mviKotlinVersion = "2.0.0"
                val mviKotlinModuleList =
                    listOf("mvikotlin", "mvikotlin-main", "mvikotlin-extensions-coroutines")
                mviKotlinModuleList.forEach {
                    implementation("com.arkivanov.mvikotlin:${it}:${mviKotlinVersion}")
                }
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
        }
    }
}
