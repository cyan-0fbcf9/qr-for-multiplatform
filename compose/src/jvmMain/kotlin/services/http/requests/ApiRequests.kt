package services.http.requests

import app.AppService
import com.fasterxml.jackson.module.kotlin.readValue
import okhttp3.Request
import services.http.HttpService
import static.url.api.ENDPOINT
import types.CheckUpdatingResponse
import java.io.IOException
import java.io.InputStreamReader
import java.lang.Exception
import kotlin.jvm.Throws

class ApiRequests(private val httpService: HttpService) {
    @Throws(Exception::class)
    suspend fun checkUpdate(currentVersion: String): Boolean {
        val request = Request.Builder().apply {
            url(ENDPOINT.CHECK_UPDATING(currentVersion))
        }.build()
        val responseBody = httpService.execute(request)?.body ?: throw Exception("request error")
        val checkUpdatingResponse =
            AppService.jacksonMapper.readValue<CheckUpdatingResponse>(InputStreamReader(responseBody.byteStream()).readText())
        return checkUpdatingResponse.existLatestVersion
    }
}