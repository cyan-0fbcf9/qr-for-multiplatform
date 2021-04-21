import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import java.io.FileWriter

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
                implementation("ru.gildor.coroutines:kotlin-coroutines-okhttp:1.0")
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
            copyright = "© 2021 Hiroyasu Niitsuma. All rights reserved."

            windows {
                menuGroup = "QR Screenshot"
                upgradeUuid = "eb5544b4-2b0c-4b73-a54e-409ec4b358b1"
            }

            macOS {
                iconFile.set(File("$projectDir/src/jvmMain/resources/assets/icon/macos/icon.icns"))
                bundleID = "com.cyan-namid09.qrscrennshot"
                signing {
                    sign.set(true)
                    identity.set("Developer ID Application: Hiroyasu Niitsuma (2CMV7D36JC)")
                }
                notarization {
                    appleID.set("cyan1109nh@icloud.com")
                    password.set("@keychain:NOTARIZATION_PASSWORD")
                }
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
