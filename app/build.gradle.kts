/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Java application project to get you started.
 * For more details on building Java & JVM projects, please refer to https://docs.gradle.org/8.3/userguide/building_java_projects.html in the Gradle documentation.
 */

plugins {
    // Apply the application plugin to add support for building a CLI application in Java.
    application
    id("org.sonarqube") version "4.2.1.3168"
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    // Use JUnit Jupiter for testing.
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.3")

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

application {
    // Define the main class for the application.
    mainClass.set("uc10.regex.App")
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}

tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = "uc10.regex.App"
    }
}

tasks.compileJava {
    sourceCompatibility = "${JavaVersion.VERSION_1_8}"
}

sonar {
    properties {
        property("sonar.projectKey", "Danhov_uc10-regex")
        property("sonar.organization", "danhov")
        property("sonar.host.url", "https://sonarcloud.io")
        property("sonar.token", "3e2efd7dd24072301286236f76e914eaa8359887")
    }
}
