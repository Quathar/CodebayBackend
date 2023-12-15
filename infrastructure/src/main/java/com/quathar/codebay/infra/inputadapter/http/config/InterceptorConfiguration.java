package com.quathar.codebay.infra.inputadapter.http.config;

import com.quathar.codebay.infra.inputadapter.http.api.BaseAPI;
import com.quathar.codebay.infra.inputadapter.http.interceptor.AuthInterceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

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

    // <<-CONSTRUCTOR->>
    /**
     * Constructs an InterceptorConfiguration with an AuthInterceptor.
     *
     * @param authInterceptor The AuthInterceptor instance to be used for authentication.
     */
    @Autowired
    public InterceptorConfiguration(AuthInterceptor authInterceptor) {
        this.authInterceptor = authInterceptor;
    }

    // <<-METHOD->>
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.authInterceptor)
                .addPathPatterns(BaseAPI.BASE_URL + "/**")
                .excludePathPatterns(BaseAPI.BASE_URL + "/users/sign-up")
                .excludePathPatterns(BaseAPI.BASE_URL + "/auth/username")
                .excludePathPatterns(BaseAPI.BASE_URL + "/auth/email")
                .excludePathPatterns(BaseAPI.BASE_URL + "/admin/**");
    }

}
