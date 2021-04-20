package services.http

import app.AppHttpClient
import okhttp3.Request
import okhttp3.Response
import services.http.requests.ApiRequests
import java.io.IOException
import java.lang.IllegalStateException

class HttpService {
    private val client = AppHttpClient.shared
    val apiRequests = ApiRequests(this)

    fun execute(request: Request): Response? = try {
        client.newCall(request).execute()
    } catch (e: IOException) {
        // TODO("Log")
        null
    } catch (e: IllegalStateException) {
        // TODO("Log")
        null
    }
}