package com.dev.dci.playstore

import com.dev.dci.plugins.Request
import createKtorClient
import io.ktor.client.request.*
import io.ktor.http.*

interface PlayStoreBillingApi {
	suspend fun verifyPurchase(request: Request): String
}

class PlayStoreBillingApiClient(private val baseUrl: String) : PlayStoreBillingApi {

	override suspend fun verifyPurchase(request: Request): String {
		val url = "$baseUrl/verifyPurchase"

		val response = ktorClient.post(url) {
			contentType(ContentType.Application.Json)
			setBody(request)
		}
		return response.toString()
	}

	companion object {
		// You can configure Ktor client settings here
		private val ktorClient = createKtorClient()
	}
}
