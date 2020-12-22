package router

import io.ktor.routing.*

fun Route.api() {
    route("api") {
        qr()
    }
}