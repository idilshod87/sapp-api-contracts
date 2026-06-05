plugins {
    kotlin("jvm") version "1.9.24"
    `maven-publish`
}

group = "com.sapp"
version = project.findProperty("version") as String? ?: "0.0.0"

repositories {
    mavenCentral()
}

dependencies {
    api("com.google.protobuf:protobuf-javalite:3.25.3")
    api("io.grpc:grpc-stub:1.65.0")
    api("io.grpc:grpc-protobuf-lite:1.65.0")
    api("io.grpc:grpc-kotlin-stub:1.4.1")
    api("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.0")
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            artifactId = "sapp-contracts-android"
            from(components["java"])
        }
    }
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/idilshod87/sapp-api-contracts")
            credentials {
                username = System.getenv("GITHUB_ACTOR")
                password = System.getenv("MAVEN_TOKEN")
            }
        }
    }
}
