package services.http

import app.AppHttpClient
import okhttp3.Request
import okhttp3.Response
import ru.gildor.coroutines.okhttp.await
import services.http.requests.ApiRequests
import java.io.IOException
import java.lang.IllegalStateException

class HttpService {
    private val client = AppHttpClient.shared
    val apiRequests = ApiRequests(this)

    suspend fun execute(request: Request): Response? = try {
        client.newCall(request).await()
    } catch (e: IOException) {
        // TODO("Log")
        null
    } catch (e: IllegalStateException) {
        // TODO("Log")
        null
    }
}