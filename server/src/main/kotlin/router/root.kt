package router

import io.ktor.application.*
import io.ktor.html.*
import io.ktor.http.content.*
import io.ktor.response.*
import io.ktor.routing.*
import java.io.File

fun Routing.root() {
    route("/") {
        static()
    }

    api()
}