package no_test

import extenstion.toByteArray
import java.awt.image.BufferedImage
import java.io.File
import java.io.FileOutputStream

val outputsDir: String = ClassLoader.getSystemResource("").path

fun saveImage(image: ByteArray, fileName: String, extension: String) {
    FileOutputStream(File("${outputsDir}${fileName}.$extension")).apply {
        write(image)
        close()
    }
}

fun saveImage(image: BufferedImage, fileName: String, extension: String) {
    saveImage(image.toByteArray(), fileName, extension)
}