
val mapstructVersion = "1.5.5.Final"

dependencies {
    // [ General ]
    implementation("org.mapstruct:mapstruct:$mapstructVersion")
    annotationProcessor("org.mapstruct:mapstruct-processor:$mapstructVersion")

    // [ Input Adapters Dependencies ]
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")

    // [ Output Adapters Dependencies ]
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
}