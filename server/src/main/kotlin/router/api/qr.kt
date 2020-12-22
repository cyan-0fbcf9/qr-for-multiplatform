package router.api

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.util.pipeline.*

fun Route.qr() {
    get("generate") {
        val value = call.request.queryParameters["value"]
        if (value != null) {
            call.respondBytes(apis.QR.generate(value), contentType = ContentType.Image.PNG)
        } else {
            respondError("query parameters error")
        }
    }
}

suspend fun PipelineContext<Unit, ApplicationCall>.respondError(message: String) {
    call.respond(message)
}