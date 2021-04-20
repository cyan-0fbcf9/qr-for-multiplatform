import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import java.io.*

plugins {
    kotlin("multiplatform") version "1.4.30"
    id("org.jetbrains.compose") version "0.3.1"
}

group = "cyan0fbcf9"
version = "1.0.0"

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
                implementation("com.squareup.okhttp3:okhttp:4.9.0")
                implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.12.+")
            }
        }

        val jvmTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation("com.google.truth:truth:1.1")
            }
        }
    }
}

compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "QR-Screenshot"
            packageVersion = getVersion() as String

            windows {
                menuGroup = "QR Screenshot"
                upgradeUuid = "eb5544b4-2b0c-4b73-a54e-409ec4b358b1"
            }
        }
    }
}

tasks.register("writeVersion", Task::class) {
    FileWriter(File("${projectDir}/src/jvmMain/resources/common/version.txt")).apply {
        write(version as String)
        close()
    }
}

tasks.build {
    dependsOn("writeVersion")
}
