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

// Adapter-REST submodules
include("infrastructure:adapter-rest:general")
include("infrastructure:adapter-rest:security")
include("infrastructure:adapter-rest:shop")
include("infrastructure:adapter-rest:management")
