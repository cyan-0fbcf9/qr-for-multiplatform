package app

import okhttp3.OkHttpClient

object AppHttpClient {
    val shared = OkHttpClient()
}