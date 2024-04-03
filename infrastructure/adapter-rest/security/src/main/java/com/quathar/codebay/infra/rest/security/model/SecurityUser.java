package com.quathar.codebay.infra.rest.security.model;

import com.quathar.codebay.domain.model.security.GrantedPermission;
import com.quathar.codebay.domain.model.security.Operation;
import com.quathar.codebay.domain.model.security.Role;

import lombok.Builder;
import lombok.Setter;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;

/**
 * <h1>Security User</h1>
 *
 * This class implements the UserDetails interface from Spring Security, providing user details
 * required for authentication and authorization.
 *
 * @since 2024-03-11
 * @version 1.0
 * @author Q
 */
@Builder
@Setter
public class SecurityUser implements UserDetails {

    // <<-CONSTANT->>
    private static final String ROLE_PREFIX = "ROLE_";

    // <<-ENUM->>
    // If we want more flexibility,
    // perhaps we can get this as constants from a .properties file
    private enum SecurityStatus { ENABLED, DISABLED, BLOCKED }

    // <<-FIELDS->>
    private String        username;
    private String        password;
    private Role          role;
    private String        status;
    private LocalDateTime passwordExpirationDate;

    // <<-METHODS->>
    @Override
    public java.util.Collection<? extends GrantedAuthority> getAuthorities() {
        java.util.Set<GrantedAuthority> grantedAuthorities = this.role
                .getGrantedPermissions()
                .stream()
                .map(GrantedPermission::getOperation)
                .map(Operation::getName)
                .map(SimpleGrantedAuthority::new)
                .collect(java.util.stream.Collectors.toSet());
        grantedAuthorities.add(new SimpleGrantedAuthority(ROLE_PREFIX + this.role.getName()));
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return SecurityStatus.valueOf(this.status) != SecurityStatus.DISABLED;
    }

    @Override
    public boolean isAccountNonLocked() {
        return SecurityStatus.valueOf(this.status) != SecurityStatus.BLOCKED;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.passwordExpirationDate.isAfter(LocalDateTime.now());
    }

    @Override
    public boolean isEnabled() {
        return SecurityStatus.valueOf(this.status) == SecurityStatus.ENABLED;
    }

}
