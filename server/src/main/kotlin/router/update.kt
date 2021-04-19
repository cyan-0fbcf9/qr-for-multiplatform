package router

import common.respondError
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import types.ApiErrorResponse
import types.CheckUpdatingResponse

const val LATEST_VERSION = "1.0.0"

fun Route.update() {
    get("check") {
        val checkedVersion = call.request.queryParameters["version"]
        if (checkedVersion == null) {
            respondError(
                ApiErrorResponse(message = "add 'version' query")
            )
        }
        call.respond(
            CheckUpdatingResponse(existLatestVersion = checkedVersion != LATEST_VERSION)
        )
    }
}