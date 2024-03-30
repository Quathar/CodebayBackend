subprojects {
    apply(plugin = "java")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")

    dependencies {
        // [ Spring Boot ]
        implementation("org.springframework.boot:spring-boot-starter-web")
        implementation("org.springframework.boot:spring-boot-starter-validation")
        implementation("org.springframework.boot:spring-boot-starter-security")
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

                if (projectName != "general" && projectName != "security")
                    implementation(project(":infrastructure:adapter-rest:security"))
            }
        }
    }
