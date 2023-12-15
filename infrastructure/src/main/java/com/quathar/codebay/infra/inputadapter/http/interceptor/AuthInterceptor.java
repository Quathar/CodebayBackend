package com.quathar.codebay.infra.inputadapter.http.interceptor;

import com.quathar.codebay.application.util.TokenManager;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * <h1>Authentication Interceptor</h1>
 *
 * @since 2023-12-13
 * @version 1.0
 * @author Q
 */
@Component
public class AuthInterceptor implements HandlerInterceptor {

    // <<-FIELD->>
    private static final String AUTH_HEADER = "Authorization";

    // <<-FIELD->>

    // <<-CONSTRUCTOR->>
//    @Autowired
//    public AuthInterceptor() {
//    }

    // <<-METHODS->>
    @Override
    public boolean preHandle(
            @NonNull
            HttpServletRequest request,
            @NonNull
            HttpServletResponse response,
            @NonNull
            Object handler
    ) {
        String token = request.getHeader(AUTH_HEADER);

        if (token == null || !token.startsWith("Bearer") || !TokenManager.verify(token)) {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(
            @NonNull
            HttpServletRequest request,
            @NonNull
            HttpServletResponse response,
            @NonNull
            Object handler,
            ModelAndView mAV
    ) {}

}
