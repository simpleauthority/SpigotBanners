plugins {
	id("org.springframework.boot") version "3.3.2"
	id("io.spring.dependency-management") version "1.1.6"
	id("com.github.ben-manes.versions") version "0.51.0"
	id("java")
}

group = "com.mcbanners"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion.set(JavaLanguageVersion.of(21))
	}
}

repositories {
	mavenCentral()
	maven("https://jitpack.io")
}

dependencies {
	implementation(platform("org.springframework.cloud:spring-cloud-dependencies:2023.0.5"))

	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-cache")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client")
	implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
	implementation("com.github.ben-manes.caffeine:caffeine:3.1.8")
	implementation("org.mariadb.jdbc:mariadb-java-client:3.4.1")
	implementation("org.flywaydb:flyway-mysql:10.16.0")
	implementation("org.flywaydb:flyway-core:10.16.0")
	implementation("io.jsonwebtoken:jjwt-api:0.12.6")
	implementation("com.github.xMrAfonso:Hangar4J:1.2.3") {
		exclude(group = "com.google.code.gson", module = "gson")
	}
	implementation("com.google.code.gson:gson:2.11.0")
	implementation("com.github.usefulness:webp-imageio:0.8.0")

	runtimeOnly("io.jsonwebtoken:jjwt-impl:0.12.6")
	runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.12.6")

	developmentOnly("org.springframework.boot:spring-boot-devtools")
}

tasks {
	bootJar {
		archiveFileName.set("bannerapi.jar")
	}
}
