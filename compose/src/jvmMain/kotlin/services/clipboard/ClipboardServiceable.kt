package services.clipboard

import java.awt.image.BufferedImage

interface ClipboardServiceable {
    fun getString(): String?
    fun getImage(): BufferedImage?
}