plugins {
    `java-library`
    `kotlin-dsl`
    `java-gradle-plugin`
    `maven-publish`
    alias(libs.plugins.gitonium.bootstrap)   // Bootstrap with previous version.
    alias(libs.plugins.kotlin.jvm)
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.jgit)
}

kotlin {
    jvmToolchain(11)
}

tasks.test {
    useJUnitPlatform()
}

gradlePlugin {
    plugins {
        create("gitonium") {
            id = "org.metaborg.gitonium"
            implementationClass = "mb.gitonium.GitoniumPlugin"
        }
    }
}
