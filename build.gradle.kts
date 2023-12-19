plugins {
    java
    id("org.springframework.boot")        version "3.2.0"
    id("io.spring.dependency-management") version "1.1.4"
}

java.sourceCompatibility = JavaVersion.VERSION_17

allprojects {
    group   = "com.quathar.codebay"
    version = "0.0.1-SNAPSHOT"

    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "java")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")

    dependencies {
        // Lombok
        compileOnly("org.projectlombok:lombok")
        annotationProcessor("org.projectlombok:lombok")

        // JUnit
        testImplementation("org.springframework.boot:spring-boot-starter-test")
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}

// <<-PROJECTS CONFIGURATION->>
project(":domain") {
    // In a typical Spring Boot project, the bootJar task
    // generates an executable JAR file containing all the necessary dependencies
    // and configurations to run the Spring Boot application.
    // On the other hand, the jar task
    // generates a standard JAR file containing only the project's compiled classes.
    tasks.getByName("bootJar") {
        enabled = false
    }

    tasks.getByName("jar") {
        enabled = true
    }
}

project(":application") {
    tasks.getByName("bootJar") {
        enabled = false
    }

    tasks.getByName("jar") {
        enabled = true
    }

    dependencies {
        implementation(project(":domain"))
    }
}

project(":infrastructure") {
    tasks.getByName("bootJar") {
        enabled = false
    }

    tasks.getByName("jar") {
        enabled = true
    }

    dependencies {
        implementation(project(":domain"))
        implementation(project(":application"))
    }
}

project(":bootloader") {
    dependencies {
        implementation(project(":domain"))
        implementation(project(":application"))
        implementation(project(":infrastructure:adapter-memory"))
        implementation(project(":infrastructure:adapter-jpa"))
        implementation(project(":infrastructure:adapter-rest"))
    }
}