@file:Suppress("FunctionName")

package static.url.api

private const val BASE_URL = "https://qr-screenshot.uc.r.appspot.com/"

object ENDPOINT {
    fun CHECK_UPDATING(currentVersion: String): String = BASE_URL + "update/check?version=$currentVersion"
}
