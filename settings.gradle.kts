rootProject.name = "Codebay"

listOf(
        "domain",

        "application",
        "application:core",
        "application:rest",

        "infrastructure",
        "infrastructure:configuration",
        "infrastructure:adapter-security",
        "infrastructure:adapter-jpa",

        "bootloader"
).forEach(::include)
