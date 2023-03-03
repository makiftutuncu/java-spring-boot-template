import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    java
    idea
    id("org.springframework.boot") version "3.0.3"
    id("io.spring.dependency-management") version "1.1.0"
    kotlin("plugin.lombok") version "1.8.0"
}

group = "dev.akif"
version = "1.0.0"

java.sourceCompatibility = JavaVersion.VERSION_17

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

idea {
    module {
        isDownloadJavadoc = true
        isDownloadSources = true
    }
}

repositories {
    mavenCentral()
    mavenLocal()
}

val springBootCrudVersion = "0.4.0"
val springdocOpenApiVersion = "2.0.2"

dependencies {
    implementation("dev.akif:spring-boot-crud-api:$springBootCrudVersion")
    implementation(kotlin("reflect"))
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:$springdocOpenApiVersion")
    implementation("org.flywaydb:flyway-core")
    compileOnly("org.projectlombok:lombok")
    runtimeOnly("org.postgresql:postgresql")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("dev.akif:spring-boot-crud-test:$springBootCrudVersion")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
    useJUnitPlatform()
    testLogging {
        events = setOf(
            TestLogEvent.PASSED,
            TestLogEvent.SKIPPED,
            TestLogEvent.FAILED
        )
        showCauses = true
        showExceptions = true
        showStackTraces = true
    }
}
