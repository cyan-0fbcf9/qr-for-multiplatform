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
        val stackedImageUrl = call.request.queryParameters["image"]
        val onColor = call.request.queryParameters["onColor"]
        val offColor = call.request.queryParameters["offColor"]

        when {
            value != null && stackedImageUrl != null ->
                call.respondBytes(
                    apis.QR.generate(value, stackedImageUrl),
                    contentType = ContentType.Image.PNG
                )
            value != null ->
                call.respondBytes(
                    apis.QR.generate(value),
                    contentType = ContentType.Image.PNG
                )
            else -> respondError(ApiErrorResponse(message = "query parameters error"))
        }
    }
}

suspend fun PipelineContext<Unit, ApplicationCall>.respondError(message: String) {
    call.respond(status = HttpStatusCode.BadRequest, message = message)
}

suspend fun PipelineContext<Unit, ApplicationCall>.respondError(apiErrorResponse: ApiErrorResponse) {
    call.respond(status = HttpStatusCode.BadRequest, message = apiErrorResponse)
}