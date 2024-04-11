package com.quathar.codebay.infra.jpa;

import com.quathar.codebay.infra.jpa.adapter.JpaUserRepositoryAdapter;
import com.quathar.codebay.infra.jpa.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;

/**
 * <h1>JPA User Repository Adapter Test</h1>
 *
 * @since 2023-12-21
 * @version 1.0
 * @author Q
 */
@DataJpaTest
@ComponentScan({"com.quathar.codebay.infra.jpa"})
@ContextConfiguration(classes = {JpaUserRepositoryAdapter.class})
class JpaUserRepositoryAdapterTest {

    // <<-FIELD->>
    private JpaUserRepositoryAdapter jpaUserRepositoryAdapter;
    private UserMapper userMapper;

    // <<-CONSTRUCTOR->>
    @Autowired
    JpaUserRepositoryAdapterTest(JpaUserRepositoryAdapter jpaUserRepositoryAdapter) {
        this.jpaUserRepositoryAdapter = jpaUserRepositoryAdapter;
        this.userMapper               = UserMapper.INSTANCE;
    }

    // <<-TESTS->>
    @Test
    void ss() {
        // TODO: Implement this
        // TODO: Implement this
        // TODO: Implement this
    }

}
