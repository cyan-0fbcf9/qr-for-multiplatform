pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}
rootProject.name = "qr-for-multiplatform"

include(":compose", ":server", ":common", ":nativeCommon")
