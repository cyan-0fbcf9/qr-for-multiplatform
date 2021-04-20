package functions

import java.io.FileReader

fun getVersion(): String? {
    return try {
        ClassLoader.getSystemResource("common/version.txt").readText()
    } catch (e: Exception) {
        null
    }
}