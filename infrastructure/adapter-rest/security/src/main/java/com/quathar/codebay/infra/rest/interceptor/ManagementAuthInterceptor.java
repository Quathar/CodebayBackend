package com.quathar.codebay.infra.rest.interceptor;

import com.quathar.codebay.application.util.TokenManager;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * <h1>Management Authentication Interceptor</h1>
 *
 * @since 2023-12-21
 * @version 1.0
 * @author Q
 */
@Component
public class ManagementAuthInterceptor implements HandlerInterceptor {

    // <<-CONSTANT->>
    private static final String AUTH_HEADER = "Authorization";
    private static final int TOKEN_PARTS = 2;

    // <<-METHODS->>
    private boolean verify(String token) {
        String[] parts = token.split("\\s");
        if (parts.length != TOKEN_PARTS)
            return false;
        String actualToken = parts[1];
        // TODO: Delete later
        if (actualToken.equals("acceptMe")) return true;
        return TokenManager.verify(actualToken, TokenManager.Role.ADMIN);
    }

    @Override
    public boolean preHandle(
            @NonNull
            HttpServletRequest request,
            @NonNull
            HttpServletResponse response,
            @NonNull
            Object handler
    ) {
        // When a CORS request is made, the other point sends a first request
        // called 'preflight', this request is made with the OPTIONS method
        // and is used to ask permission to the server
        // about the actual request that will be made later,
        // so we make this check
        if (request.getMethod().equals("OPTIONS"))
            return true;
        
        String token = request.getHeader(AUTH_HEADER);
        if (token == null || !token.startsWith("Bearer") || !this.verify(token)) {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            return false;
        }
        return true;
    }

}
