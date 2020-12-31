package no_test

import extenstion.toByteArray
import java.awt.image.BufferedImage
import java.io.File
import java.io.FileOutputStream

const val outputsDir = "src/test/resources/outputs/"

fun saveImage(image: ByteArray, fileName: String, extension: String) {
    FileOutputStream(File("${outputsDir}${fileName}.$extension")).apply {
        write(image)
        close()
    }
}

fun saveImage(image: BufferedImage, fileName: String, extension: String) {
    saveImage(image.toByteArray(), fileName, extension)
}