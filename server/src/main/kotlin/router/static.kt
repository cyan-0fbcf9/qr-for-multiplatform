package router

import io.ktor.http.content.*
import io.ktor.routing.*
import router.static

fun Route.static() {
    static {
        staticBasePackage = "static"
        // NOTE: scoping all built resources
        resources(".")
        defaultResource("index.html")
    }
}