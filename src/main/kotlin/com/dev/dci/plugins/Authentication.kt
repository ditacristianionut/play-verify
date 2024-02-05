package com.dev.dci.plugins

import io.ktor.server.application.*
import io.ktor.server.auth.*

fun Application.configureAuthentication() {
	install(Authentication) {
		basic(name = "userAuth") {
			realm = "Verifier"
			validate { credentials ->
//				authService.authenticate(credentials.name, credentials.password)
				if (credentials.name == "dci" && credentials.password == "dci") {
					UserIdPrincipal(credentials.name)
				} else {
					null
				}
			}
		}
	}
}