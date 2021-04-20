package router.api

import common.respondError
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
