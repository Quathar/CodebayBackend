subprojects {
    dependencies {
        implementation( project(":${ Module.DOMAIN }") )
    }
}

// <<-PROJECTS CONFIGURATION->>
listOf(Module.APP_CORE, Module.APP_REST)
        .forEach { projectName ->
            project(":$projectName") {
                tasks.getByName("bootJar") {
                    enabled = false
                }

                tasks.getByName("jar") {
                    enabled = true
                }
            }
        }

project(":${ Module.APP_REST }") {
    dependencies {
        // [ Module ]
        implementation( project(":${ Module.APP_CORE }") )

        // [ Spring Boot ]
        implementation( Lib.SPRING_BOOT_WEB        )
        implementation( Lib.SPRING_BOOT_VALIDATION )
        implementation( Lib.SPRING_BOOT_SECURITY   )
    }
}
