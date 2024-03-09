package com.quathar.codebay.infra.rest.interceptor;

import com.quathar.codebay.application.util.TokenManager;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
public class ShopAuthInterceptor implements HandlerInterceptor {

    // <<-CONSTANT->>
    private static final String AUTH_HEADER = "Authorization";
    private static final int TOKEN_PARTS = 2;

    // <<-METHODS->>
    private boolean verify(String token) {
        String[] parts = token.split("\\s");
        if (parts.length != TOKEN_PARTS)
            return false;
        String actualToken = parts[1];
        return TokenManager.verify(actualToken);
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
        String token = request.getHeader(AUTH_HEADER);
        if (token == null || !token.startsWith("Bearer") || !this.verify(token)) {
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
