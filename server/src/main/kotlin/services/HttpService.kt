package services

import kotlinx.coroutines.*
import okhttp3.OkHttpClient
import okhttp3.Request
import java.awt.image.BufferedImage
import java.io.IOException
import javax.imageio.ImageIO

object HttpService {
    private val client = OkHttpClient()

    suspend fun downloadImage(url: String): BufferedImage? {
        val request = Request.Builder().apply {
            url(url)
        }.build()
        val call = this.client.newCall(request)
        return withContext(Dispatchers.IO) {
            val response = try {
                call.execute()
            } catch (e: IOException) {
                return@withContext null
            } catch (e: Exception) {
                return@withContext null
            }
            if (response.isSuccessful &&
                response.headers["Content-Type"]?.matches(Regex("^image/.*$")) == true
            ) {
                return@withContext ImageIO.read(response.body?.byteStream())
            } else {
                return@withContext null
            }
        }
    }

}