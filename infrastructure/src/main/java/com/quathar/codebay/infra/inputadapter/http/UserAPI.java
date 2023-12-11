package com.quathar.codebay.infra.inputadapter.http;

import com.quathar.codebay.domain.model.User;
import com.quathar.codebay.application.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * <h1>User API</h1>
 *
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
@RestController
@RequestMapping("/api/v2/users")
public class UserAPI {

    // <<-FIELD->>
    private final UserService userService;

    // <<-CONSTRUCTOR->>
    @Autowired
    public UserAPI(UserService userService) {
        this.userService = userService;
    }

    // <<-METHODS->>
    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable UUID id) {
        User user = this.userService.getById(id);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/sign-up")
    public ResponseEntity<User> create() {
        User user = this.userService.create(null);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable UUID id) {
        User user = this.userService.update(null);
        return ResponseEntity.ok().body(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        this.userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
