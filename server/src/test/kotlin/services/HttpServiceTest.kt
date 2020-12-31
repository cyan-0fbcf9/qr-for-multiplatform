package services

import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import org.junit.Test

class HttpServiceTest {
    @Test
    fun testDownloadImageWithRightUrl(): Unit = runBlocking {
        val imageUrl = "https://firebase.google.com/images/brand-guidelines/logo-logomark.png?hl=ja"
        Truth.assertThat(HttpService.downloadImage(url = imageUrl)).apply {
            isNotNull()
        }
    }

    @Test
    fun testDownloadImageWithMissingUrl(): Unit = runBlocking {
        val imageUrl = "https://hohoge.com/top.png"
        Truth.assertThat(HttpService.downloadImage(url = imageUrl)).apply {
            isNull()
        }
    }
}