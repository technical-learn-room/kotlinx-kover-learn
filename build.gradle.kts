import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import kotlinx.kover.api.KoverTaskExtension
import kotlinx.kover.api.CoverageEngine
import kotlinx.kover.api.VerificationValueType

plugins {
    kotlin("jvm") version "1.5.31"
    id("org.jetbrains.kotlinx.kover") version "0.4.2"
    application
}

group = "com.kotlinx"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    extensions.configure(KoverTaskExtension::class) {
        isEnabled = true
        includes = listOf("a.TestClass.kt")
    }
    useJUnitPlatform()
}

kover {
    isEnabled = true
    coverageEngine.set(CoverageEngine.JACOCO)
    jacocoEngineVersion.set("0.8.7")
    generateReportOnCheck.set(true)
}

tasks.koverVerify {
    rule {
        bound {
            minValue = 100
            maxValue = 100
            valueType = VerificationValueType.COVERED_LINES_PERCENTAGE
        }
    }
}


tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}