package router

import apis.QR
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.util.pipeline.*

fun Route.qr() {
    val qr = QR()

    route("qr") {
        get("generate") {
            val value = call.request.queryParameters["value"]
            if (value != null) {
                call.respondBytes(qr.generate(value), contentType = ContentType.Image.PNG)
            } else {
                respondError("query parameters error")
            }
        }
    }
}

suspend fun PipelineContext<Unit, ApplicationCall>.respondError(message: String) {
    call.respond(message)
}