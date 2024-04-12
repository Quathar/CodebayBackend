object Lib {
    private const val LOMBOK_ORG    = "org.projectlombok"
    private const val SPRING_ORG    = "org.springframework.boot"
    private const val MAPSTRUCT_ORG = "org.mapstruct"

    const val LOMBOK                 = "$LOMBOK_ORG:lombok"
    const val LOMBOK_PROCESSOR       = "$LOMBOK_ORG:lombok"
    const val SPRING_CONTEXT         = "org.springframework:spring-context"
    const val SPRING_BOOT_STARTER    = "$SPRING_ORG:spring-boot-starter"
    const val SPRING_BOOT_TEST       = "$SPRING_ORG:spring-boot-starter-test"
    const val SPRING_BOOT_WEB        = "$SPRING_ORG:spring-boot-starter-web"
    const val SPRING_BOOT_VALIDATION = "$SPRING_ORG:spring-boot-starter-validation"
    const val SPRING_BOOT_SECURITY   = "$SPRING_ORG:spring-boot-starter-security"
    const val SPRING_BOOT_DATA_JPA   = "$SPRING_ORG:spring-boot-starter-data-jpa"
    const val H2                     = "com.h2database:h2"
    const val MAPSTRUCT              = "$MAPSTRUCT_ORG:mapstruct:${Version.MAPSTRUCT_VERSION}"
    const val MAPSTRUCT_PROCESSOR    = "$MAPSTRUCT_ORG:mapstruct-processor:${Version.MAPSTRUCT_VERSION}"
    const val AUTH0_JWT              = "com.auth0:java-jwt:${Version.AUTH0_JWT_VERSION}"
}
