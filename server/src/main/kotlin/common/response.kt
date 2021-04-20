package common

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.util.pipeline.*
import types.ApiErrorResponse

suspend fun PipelineContext<Unit, ApplicationCall>.respondError(message: String) {
    call.respond(status = HttpStatusCode.BadRequest, message = message)
}

suspend fun PipelineContext<Unit, ApplicationCall>.respondError(apiErrorResponse: ApiErrorResponse) {
    call.respond(status = HttpStatusCode.BadRequest, message = apiErrorResponse)
}