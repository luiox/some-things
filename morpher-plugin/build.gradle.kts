plugins {
    id("java")
}

group = "com.github.luiox"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven { url = uri("https://jitpack.io")  }
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    implementation("com.github.luiox:morpher-api:v1.6")
}

tasks.test {
    useJUnitPlatform()
}