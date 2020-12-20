package router

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Routing.root() {
    get("/") {
        call.respondText("Hello")
    }
}