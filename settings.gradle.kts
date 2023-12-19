rootProject.name = "codebay"

// Modules
include("bootloader")
include("infrastructure")
include("application")
include("domain")

// Infrastructure submodules
include("infrastructure:adapter-rest")
include("infrastructure:adapter-jpa")
include("infrastructure:adapter-memory")
