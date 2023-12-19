
dependencies {
    // [ Spring Boot ]
    // Dependency added solely to utilize the @Component annotation
    // This annotation helps in declaring beans without explicitly creating a bean definition
    // It enhances convenience by enabling automatic bean discovery and instantiation
    implementation("org.springframework:spring-context")
}
