import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.apache.tools.ant.taskdefs.condition.Os

plugins {
    kotlin("jvm") version "1.4.20"
    application
}

group = "cyan0fbcf9"
version = "1.0"

repositories {
    jcenter()
    maven { url = uri("https://dl.bintray.com/kotlin/kotlinx") }
    maven { url = uri("https://dl.bintray.com/kotlin/ktor") }
}

dependencies {
    implementation(project(":common"))
    testImplementation(kotlin("test-junit"))

    val ktorVersion = "1.4.3"
    implementation("io.ktor:ktor-server-netty:$ktorVersion")
    implementation("io.ktor:ktor-html-builder:$ktorVersion")
    implementation("io.ktor:ktor-jackson:$ktorVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-html-jvm:0.7.2")

    val logbackVersion = "1.2.1"
    implementation("ch.qos.logback:logback-classic:$logbackVersion")
}

tasks.test {
    useJUnit()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClassName = "io.ktor.server.netty.EngineMain"
}

fun Exec.execCommand(command: String) {
    when {
        Os.isFamily(Os.FAMILY_WINDOWS) -> {
            commandLine = listOf("powershell", "-Command", command)
        }
        Os.isFamily(Os.FAMILY_MAC) -> {
            commandLine = listOf("zsh", "-c", command)
        }
        Os.isFamily(Os.FAMILY_UNIX) -> {
            commandLine = listOf("bash", "-c", command)
        }
    }
}

tasks.register("npmInstall", Exec::class) {
    val npmCommand = "npm --prefix ${projectDir}/web install ${projectDir}/web"
    execCommand(npmCommand)
}

tasks.register("npmLint", Exec::class) {
    val npmCommand = "npm --prefix ${projectDir}/web run lint"
    execCommand(npmCommand)
}

tasks.register("npmBuild", Exec::class) {
    if (file("${projectDir}/web/node_modules").exists().not()) {
        dependsOn("npmInstall")
    }

    dependsOn("npmLint")
    val npmCommand = "npm --prefix ${projectDir}/web run build"
    execCommand(npmCommand)
}

tasks.processResources {
    dependsOn("npmBuild")
}