object Module {
    // <<-DOMAIN->>
    const val DOMAIN = "domain"

    // <<-APPLICATION->>
    const val APP      = "application"
    const val APP_CORE = "$APP:core"
    const val APP_REST = "$APP:rest"

    // <<-INFRASTRUCTURE->>
    const val INFRA            = "infrastructure"
    const val CONFIGURATION    = "$INFRA:configuration"
    const val JPA_ADAPTER      = "$INFRA:adapter-jpa"
    const val SECURITY_ADAPTER = "$INFRA:adapter-security"

    // <<-BOOTLOADER->>
    const val BOOTLOADER = "bootloader"
}
