package router

import io.ktor.http.content.*
import io.ktor.routing.*
import router.static

fun Route.static() {
    static {
        staticBasePackage = "/static"
        defaultResource("index.html")
    }
}