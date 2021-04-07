plugins {
    kotlin("multiplatform") version "1.4.20"
}

group = "cyan0fbcf9"
version = "1.0"

repositories {
    mavenCentral()
}

kotlin {
    /* Targets configuration omitted. 
    *  To find out how to configure the targets, please follow the link:
    *  https://kotlinlang.org/docs/reference/building-mpp-with-gradle.html#setting-up-targets */
    macosX64()
    mingwX64()
    jvm()

    sourceSets {
        val jvmMain by getting {
            dependencies {
                implementation(kotlin("stdlib-jdk8"))
            }
        }
    }
}
