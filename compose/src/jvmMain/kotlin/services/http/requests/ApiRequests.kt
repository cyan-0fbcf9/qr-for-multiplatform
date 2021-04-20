package services.http.requests

import app.AppService
import com.fasterxml.jackson.module.kotlin.readValue
import okhttp3.Request
import services.http.HttpService
import static.url.api.ENDPOINT
import types.CheckUpdatingResponse
import java.io.IOException

class ApiRequests(private val httpService: HttpService) {
    @Throws(IOException::class)
    fun checkUpdate(currentVersion: String): Boolean {
        val request = Request.Builder().apply {
            url(ENDPOINT.CHECK_UPDATING(currentVersion + "hoge"))
        }.build()
        val responseBody = httpService.execute(request)?.body ?: throw IOException("request error")
        val checkUpdatingResponse = AppService.jacksonMapper.readValue<CheckUpdatingResponse>(responseBody.string())
        return checkUpdatingResponse.existLatestVersion
    }
}