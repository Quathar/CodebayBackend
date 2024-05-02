subprojects {
    dependencies {
        // [ Modules ]
        implementation( project(":${ Module.DOMAIN   }") )
        implementation( project(":${ Module.APP_CORE }") )
    }
}

// <<-PROJECTS CONFIGURATION->>
listOf(Module.CONFIGURATION, Module.SECURITY_ADAPTER, Module.JPA_ADAPTER)
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

project(":${ Module.JPA_ADAPTER }") {
    dependencies {
        implementation     ( Lib.SPRING_BOOT_DATA_JPA )
        implementation     ( Lib.MAPSTRUCT            )
        annotationProcessor( Lib.MAPSTRUCT_PROCESSOR  )
    }
}

project(":${ Module.SECURITY_ADAPTER }") {
    dependencies {
        implementation     ( Lib.SPRING_BOOT_SECURITY )
        implementation     ( Lib.AUTH0_JWT            )
        implementation     ( Lib.MAPSTRUCT            )
        annotationProcessor( Lib.MAPSTRUCT_PROCESSOR  )
    }
}

project(":${ Module.CONFIGURATION }") {
    dependencies {
        implementation( project(":${ Module.SECURITY_ADAPTER }") )
        implementation( project(":${ Module.JPA_ADAPTER      }") )
        implementation( Lib.SPRING_CONTEXT                       )
    }
}
