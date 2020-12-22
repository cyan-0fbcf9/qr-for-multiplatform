package router

import io.ktor.routing.*
import router.api.qr

fun Route.api() {
    route("qr") {
        qr()
    }
}