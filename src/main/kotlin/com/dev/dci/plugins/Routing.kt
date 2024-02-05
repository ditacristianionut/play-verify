package com.dev.dci.plugins

import com.dev.dci.playstore.PlayStoreBillingApiClient
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

val playStoreBillingApi = PlayStoreBillingApiClient("https://play.googleapis.com/billing")

fun Application.configureRouting() {
    install(StatusPages) {
        exception<Throwable> { call, cause ->
            call.respondText(text = "500: $cause" , status = HttpStatusCode.InternalServerError)
        }
        exception<Throwable> { call, cause ->
            call.respondText(text = "40x: $cause" , status = HttpStatusCode.NotAcceptable)
        }
    }

        install(ContentNegotiation) {
            json(
                Json {
                    prettyPrint = true
                    isLenient = true
                }
            )
        }

    routing {
        get("/") {
            call.respondText("Hello World!")
        }
    }
    routing {
        get("/info") {
            call.respond(Response(status = "info for uat?"))
        }
    }
    routing {
        post("/verify") {
            val request = call.receive<Request>()

            playStoreBillingApi.verifyPurchase(request)

            call.respond(request)
        }
    }
}

@Serializable
data class Request(
    val userId: String,
    val packageName: String,
    val productId: String,
    val token: String
)

@Serializable
data class Response(val status: String)