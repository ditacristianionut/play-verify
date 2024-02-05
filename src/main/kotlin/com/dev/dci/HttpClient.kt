import io.ktor.client.*
import io.ktor.client.engine.cio.*


fun createKtorClient(): HttpClient {
	val client = HttpClient(CIO) {
//		install(Logging)
	}

	return client
//	return HttpClient(OkHttp) {
//		install(Logging) {
//			level = LogLevel.ALL // Adjust the log level as needed
//		}
////		install(timeout) {
////			requestTimeoutMillis = 15000 // Adjust the timeout as needed (in milliseconds)
////		}
//
//		install(ContentNegotiation) {
//			json(
//				Json {
//					prettyPrint = true
//					isLenient = true
//				}
//			)
//		}
//	}
}
