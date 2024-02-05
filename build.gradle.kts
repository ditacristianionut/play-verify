
val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project

plugins {
    kotlin("jvm") version "1.9.22"
    id("io.ktor.plugin") version "2.3.7"
    kotlin("plugin.serialization") version "1.9.22"
}

group = "com.dev.dci"
version = "0.0.1"

application {
    mainClass.set("com.dev.dci.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core-jvm")
    implementation("io.ktor:ktor-server-auth-jvm")
//    implementation("io.ktor:ktor-server-freemarker-jvm")

    implementation("io.ktor:ktor-server-freemarker:$ktor_version")
//    implementation("io.ktor:ktor-server-thymeleaf:$ktor_version")
//    implementation("io.ktor:ktor-server-mustache:$ktor_version")

    implementation("io.ktor:ktor-server-content-negotiation-jvm")
//    implementation("com.hypercubetools:ktor-moshi:3.0.0")
//    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.2")
//    implementation("io.ktor:ktor-serialization:$ktor_version")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktor_version")

    implementation("io.ktor:ktor-server-host-common-jvm")
    implementation("io.ktor:ktor-server-status-pages-jvm")
    implementation("io.ktor:ktor-server-netty-jvm")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    testImplementation("io.ktor:ktor-server-tests-jvm")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")

//    implementation("io.ktor:ktor-client-serialization:1.6.7")
//    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.1")
//    implementation("io.ktor:ktor-client-okhttp:1.6.7")
//    implementation("io.ktor:ktor-client-logging:1.6.7")

    implementation("io.ktor:ktor-client-core:$ktor_version")
    implementation("io.ktor:ktor-client-cio:$ktor_version")
}
