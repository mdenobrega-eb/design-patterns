

val coroutinesVersion = "1.6.1"
val kotestVersion = "4.6.0"
val springFrameworkVersion = "5.3.18"
val logbackContribVersion = "0.1.5"
val dataFakerVersion = "1.6.0"

sourceSets.main {
    java.srcDirs(
        "./Main.kt",
        "src",
        "tests",
    )
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
}

repositories {
    mavenLocal()
    google()
    mavenCentral()
}

plugins {
    application
    idea
    kotlin("jvm") version "1.8.0"
    id("org.jlleitschuh.gradle.ktlint") version "11.0.0"
    kotlin("plugin.spring") version "1.8.0"
    id("org.springframework.boot") version "2.7.8"
    id("io.spring.dependency-management") version "1.1.0"
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.2")
    implementation("javax.annotation:javax.annotation-api:1.3.2")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.jgrapht:jgrapht-core:1.5.1")
    implementation("io.micrometer:micrometer-registry-statsd:1.8.2")
    implementation("ch.qos.logback.contrib:logback-jackson:$logbackContribVersion")
    implementation("ch.qos.logback.contrib:logback-json-classic:$logbackContribVersion")
    implementation("org.eclipse.jetty:jetty-server:11.0.10")
    implementation("org.eclipse.jetty:jetty-io:11.0.10")

    testImplementation("com.almworks.sqlite4java:sqlite4java:1.0.392")
    testImplementation("io.kotest:kotest-runner-junit5:$kotestVersion")
    testImplementation("io.kotest:kotest-assertions-core:$kotestVersion")
    testImplementation("io.kotest:kotest-framework-datatest:$kotestVersion")
    testImplementation("io.mockk:mockk:1.11.0")
    testImplementation("net.datafaker:datafaker:$dataFakerVersion")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.register<Copy>("copyDeps") {
    from(configurations.testImplementation) {
        include("*.dll")
        include("*.dylib")
        include("*.so")
    }
    into("build/libs")
}

tasks.test {
    dependsOn(tasks["copyDeps"])
    systemProperty("java.library.path", "build/libs")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}

configurations {
    testImplementation.get().isCanBeResolved = true
}
