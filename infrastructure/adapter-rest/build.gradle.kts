subprojects {
    apply(plugin = "java")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")

    dependencies {
        // [ Spring Boot ]
        implementation("org.springframework.boot:spring-boot-starter-web")
        implementation("org.springframework.boot:spring-boot-starter-validation")
    }
}

// <<-PROJECTS CONFIGURATION->>
listOf("general", "security", "shop", "management")
    .forEach { projectName ->
        project(":infrastructure:adapter-rest:$projectName") {
            tasks.getByName("bootJar") {
                enabled = false
            }

            tasks.getByName("jar") {
                enabled = true
            }

            dependencies {
                implementation(project(":infrastructure:adapter-jpa"))
                implementation(project(":infrastructure:adapter-memory"))

                if (projectName != "general")
                    implementation(project(":infrastructure:adapter-rest:general"))
            }
        }
    }
