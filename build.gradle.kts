plugins {
    java
}

group = "us.airt"
version = "0.1.0"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.fasterxml.jackson.core:jackson-databind:2.17.2")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.17.2")

    // Runtime foundations requested by spec
    implementation("org.lwjgl:lwjgl:3.3.4")
    implementation("org.spongepowered:mixin:0.8.5")

    // JS runtime hook (placeholder-ready)
    implementation("org.graalvm.js:js-scriptengine:24.1.0")

    testImplementation("org.junit.jupiter:junit-jupiter:5.11.0")
}

tasks.test {
    useJUnitPlatform()
}
