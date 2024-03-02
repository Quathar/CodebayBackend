package com.quathar.codebay.infra.rest.conf;

import com.quathar.codebay.infra.rest.interceptor.AuthInterceptor;
import com.quathar.codebay.infra.rest.interceptor.ManagementAuthInterceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static com.quathar.codebay.infra.rest.api.BaseAPI.BASE_URL;
import static com.quathar.codebay.infra.rest.management.api.ManagementAPI.MANAGE_URL;

/**
 * <h1>Interceptor Configuration</h1>
 * <br>
 * <p>
 *     This configuration class sets up interceptors for handling specific
 *     requests and includes exclusion paths for certain endpoints.
 * </p>
 *
 * @since 2023-12-13
 * @version 1.0
 * @author Q
 */
@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {

    // <<-FIELDS->>
    /**
     * The AuthInterceptor instance used for authentication.
     */
    private final AuthInterceptor authInterceptor;
    /**
     * The ManagementAuthInterceptor instance used for authentication.
     */
    private final ManagementAuthInterceptor managementAuthInterceptor;

    // <<-CONSTRUCTOR->>
    /**
     * Constructs an InterceptorConfiguration with an AuthInterceptor.
     *
     * @param authInterceptor The AuthInterceptor instance to be used for authentication.
     */
    @Autowired
    public InterceptorConfiguration(AuthInterceptor authInterceptor, ManagementAuthInterceptor managementAuthInterceptor) {
        this.authInterceptor           = authInterceptor;
        this.managementAuthInterceptor = managementAuthInterceptor;
    }

    // <<-METHOD->>
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.authInterceptor)
                .addPathPatterns    (BASE_URL + "/**")
                .excludePathPatterns(BASE_URL + "/users/sign-up")
                .excludePathPatterns(BASE_URL + "/auth/username")
                .excludePathPatterns(BASE_URL + "/auth/email")
                .excludePathPatterns(BASE_URL + "/management/**");
        registry.addInterceptor(this.managementAuthInterceptor)
                .addPathPatterns    (MANAGE_URL + "/**")
                .excludePathPatterns(MANAGE_URL + "/admins/sign-up")
                .excludePathPatterns(MANAGE_URL + "/auth/username")
                .excludePathPatterns(MANAGE_URL + "/auth/email");
    }

}
