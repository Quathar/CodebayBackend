plugins {
    java
    id( Plugin.SPRING_BOOT_PLUGIN ) version Version.SPRING_BOOT_VERSION
    id( Plugin.SPRING_DM          ) version Version.SPRING_DM_VERSION
}

allprojects {
    apply( plugin = Plugin.JAVA_PLUGIN        )
    apply( plugin = Plugin.SPRING_BOOT_PLUGIN )
    apply( plugin = Plugin.SPRING_DM          )

    group   = "com.quathar.codebay"
    version = "0.0.1-SNAPSHOT"

    java {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    repositories {
        mavenCentral()
    }

    dependencies {
        compileOnly        ( Lib.LOMBOK           )
        annotationProcessor( Lib.LOMBOK_PROCESSOR )
        testImplementation ( Lib.SPRING_BOOT_TEST )
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}

// <<-PROJECTS CONFIGURATION->>
listOf(Module.DOMAIN, Module.APP, Module.INFRA)
        .forEach { projectName ->
            project(":$projectName") {
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
        }

project(":${ Module.DOMAIN }") {
    // Not necessary
    // Only showing that domain doesn't have any dependency on other modules
}

project(":${ Module.APP }") {
    dependencies {
        implementation( project(":${ Module.DOMAIN }") )
    }
}

project(":${ Module.INFRA }") {
    dependencies {
        implementation( project(":${ Module.DOMAIN   }") )
        implementation( project(":${ Module.APP_CORE }") )
    }
}

project(":${ Module.BOOTLOADER }") {
    dependencies {
        implementation( project(":${ Module.APP_REST         }") )
        implementation( project(":${ Module.CONFIGURATION    }") )
        implementation( project(":${ Module.SECURITY_ADAPTER }") )
        implementation( project(":${ Module.JPA_ADAPTER      }") )
    }
}
