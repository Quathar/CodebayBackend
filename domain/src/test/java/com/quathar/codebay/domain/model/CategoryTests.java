package com.quathar.codebay.domain.model;

import com.quathar.codebay.domain.manager.MockProvider;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <h1>Category Model Tests</h1>
 *
 * @since 2023-12-09
 * @version 1.0
 * @author Q
 */
class CategoryTests {

    // <<-FIELD->>
    private Category mock;

    // <<-TESTS->>
    @BeforeEach
    void setUp() {
        this.mock = MockProvider.getInstance(Category.class);
    }

    @Test
    void fullArgsConstructorTest() {
        Category category = new Category(
                this.mock.getId(),
                this.mock.getCode(),
                this.mock.getDescription(),
                this.mock.getParentCategory(),
                this.mock.getChildCategories(),
                this.mock.getAudit()
        );

        assertThat( category.getId()               ).isEqualTo( this.mock.getId() );
        assertThat( category.getCode()             ).isEqualTo( this.mock.getCode() );
        assertThat( category.getDescription()      ).isEqualTo( this.mock.getDescription() );
        assertThat( category.getParentCategory()   ).isEqualTo( this.mock.getParentCategory() );
        assertThat( category.getChildCategories()  ).isEqualTo( this.mock.getChildCategories() );
        assertThat( category.getAudit()            ).isEqualTo( this.mock.getAudit() );
    }

    @Test
    void setterTest() {
        Category category = Category.builder().build();

        category.setId             ( this.mock.getId() );
        category.setCode           ( this.mock.getCode() );
        category.setDescription    ( this.mock.getDescription() );
        category.setParentCategory ( this.mock.getParentCategory() );
        category.setChildCategories( this.mock.getChildCategories() );
        category.setAudit          ( this.mock.getAudit() );

        assertThat( category.getId()               ).isEqualTo( this.mock.getId() );
        assertThat( category.getCode()             ).isEqualTo( this.mock.getCode() );
        assertThat( category.getDescription()      ).isEqualTo( this.mock.getDescription() );
        assertThat( category.getParentCategory()   ).isEqualTo( this.mock.getParentCategory() );
        assertThat( category.getChildCategories()  ).isEqualTo( this.mock.getChildCategories() );
        assertThat( category.getAudit()            ).isEqualTo( this.mock.getAudit() );
    }

    @Test
    void builderTest() {
        Category category = Category.builder()
                .id             ( this.mock.getId() )
                .code           ( this.mock.getCode() )
                .description    ( this.mock.getDescription() )
                .parentCategory ( this.mock.getParentCategory() )
                .childCategories( this.mock.getChildCategories() )
                .audit          ( this.mock.getAudit() )
                .build();

        assertThat( category.getId()               ).isEqualTo( this.mock.getId() );
        assertThat( category.getCode()             ).isEqualTo( this.mock.getCode() );
        assertThat( category.getDescription()      ).isEqualTo( this.mock.getDescription() );
        assertThat( category.getParentCategory()   ).isEqualTo( this.mock.getParentCategory() );
        assertThat( category.getChildCategories()  ).isEqualTo( this.mock.getChildCategories() );
        assertThat( category.getAudit()            ).isEqualTo( this.mock.getAudit() );
    }

}
