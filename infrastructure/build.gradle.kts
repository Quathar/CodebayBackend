
val mapstructVersion = "1.5.5.Final"

subprojects {
    apply(plugin = "java")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")

    dependencies {
        // [ Modules ]
        implementation(project(":domain"))
        implementation(project(":application"))

        // [ Mapstruct ]
        implementation("org.mapstruct:mapstruct:$mapstructVersion")
        annotationProcessor("org.mapstruct:mapstruct-processor:$mapstructVersion")
    }
}

// <<-PROJECTS CONFIGURATION->>
listOf(
        "adapter-memory",
        "adapter-jpa",
        "adapter-rest"
).forEach { projectName ->
    project(":infrastructure:$projectName") {
        tasks.getByName("bootJar") {
            enabled = false
        }

        tasks.getByName("jar") {
            enabled = true
        }
    }
}

project(":infrastructure:adapter-rest") {
    dependencies {
        implementation(project(":infrastructure:adapter-jpa"))
        implementation(project(":infrastructure:adapter-memory"))
    }
}
