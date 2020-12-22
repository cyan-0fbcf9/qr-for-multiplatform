package router.api

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.util.pipeline.*
import types.ApiErrorResponse

fun Route.qr() {
    get("generate") {
        val value = call.request.queryParameters["value"]
        if (value != null) {
            call.respondBytes(apis.QR.generate(value), contentType = ContentType.Image.PNG)
        } else {
            respondError(ApiErrorResponse(message = "query parameters error"))
        }
    }
}

suspend fun PipelineContext<Unit, ApplicationCall>.respondError(message: String) {
    call.respond(status = HttpStatusCode.BadRequest, message = message)
}

suspend fun PipelineContext<Unit, ApplicationCall>.respondError(apiErrorResponse: ApiErrorResponse) {
    call.respond(status = HttpStatusCode.BadRequest, message = apiErrorResponse)
}