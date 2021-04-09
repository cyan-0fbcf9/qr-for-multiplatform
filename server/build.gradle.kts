import org.apache.tools.ant.taskdefs.condition.Os
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.30"
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
    testImplementation("com.google.truth:truth:1.1")

    val ktorVersion = "1.4.3"
    implementation("io.ktor:ktor-server-netty:$ktorVersion")
    implementation("io.ktor:ktor-html-builder:$ktorVersion")
    implementation("io.ktor:ktor-jackson:$ktorVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-html-jvm:0.7.2")

    val logbackVersion = "1.2.1"
    implementation("ch.qos.logback:logback-classic:$logbackVersion")

    val daggerVersion = "2.30.1"
    api("com.google.dagger:dagger:${daggerVersion}")
    annotationProcessor("com.google.dagger:dagger-compiler:${daggerVersion}")

    val okhttpVersion = "4.9.0"
    implementation("com.squareup.okhttp3:okhttp:${okhttpVersion}")
    implementation(kotlin("stdlib-jdk8"))
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
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}