package com.quathar.codebay.domain;

import com.quathar.codebay.domain.model.Administrator;
import com.quathar.codebay.domain.model.User;
import com.quathar.codebay.domain.model.security.GrantedPermission;
import com.quathar.codebay.domain.model.security.Operation;
import com.quathar.codebay.domain.model.security.Role;
import com.quathar.codebay.domain.model.shop.Product;
import com.quathar.codebay.domain.valueobject.Audit;
import com.quathar.codebay.domain.valueobject.Document;
import com.quathar.codebay.domain.valueobject.PersonalInfo;
import com.quathar.codebay.domain.valueobject.Phone;
import com.quathar.codebay.domain.valueobject.security.RoleOperations;
import com.quathar.codebay.domain.valueobject.security.TokenPair;
import com.quathar.codebay.domain.valueobject.shop.Image;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.stream.Stream;

/**
 * <h1>Model Provider</h1>
 *
 * Provides instances of different models.
 *
 * @since 2023-12-09
 * @version 1.0
 * @author Q
 */
public class MockProvider {

    // <<-CONSTANTS->>
    private static final int INTEGER = 0;
    private static final String STRING = "string";
    private static final UUID IDENTIFIER = UUID.randomUUID();
    private static final LocalDateTime NOW = LocalDateTime.now();

    // <<-METHODS->>
    public static <M> M getInstance(Class<M> clazz) {
        return clazz.cast(createInstance(clazz));
    }

    private static Object createInstance(Class<?> clazz) {
        return switch (clazz.getSimpleName()) {
            case "Role"              -> getRoleModel();
            case "Operation"         -> getOperationModel();
            case "GrantedPermission" -> getGrantedPermissionModel();
            case "TokenPair"         -> getTokenPairModel();
            case "RoleOperations"    -> getRoleOperationsModel();
            // ---
            case "User"          -> getUserModel();
            case "Administrator" -> getAdministratorModel();
            case "Audit"         -> getAuditModel();
            case "PersonalInfo"  -> getPersonalInfoModel();
            case "Document"      -> getDocumentModel();
            case "Phone"         -> getPhoneModel();
            // ---
            case "Product" -> getProductModel();
            default -> null;
        };
    }

    // [ SECURITY ]
    private static Role getRoleModel() {
        return Role.builder()
                .id( IDENTIFIER )
                .name( STRING )
                .description( STRING )
                .grantedPermissions( Stream.of( GrantedPermission.builder().build()) )
                .build();
    }

    private static Operation getOperationModel() {
        return Operation.builder()
                .id( IDENTIFIER )
                .name( STRING )
                .build();
    }

    private static GrantedPermission getGrantedPermissionModel() {
        return GrantedPermission.builder()
                .id( IDENTIFIER )
                .role( getRoleModel() )
                .operation( getOperationModel() )
                .build();
    }

    private static TokenPair getTokenPairModel() {
        return TokenPair.builder()
                .accessToken( STRING )
                .refreshToken( STRING )
                .build();
    }

    private static RoleOperations getRoleOperationsModel() {
        return RoleOperations.builder()
                .role( STRING )
                .operations( Stream.of(STRING) )
                .build();
    }

    // [ USER ]
    private static User getUserModel() {
        return User.builder()
                .id( IDENTIFIER )
                .username( STRING )
                .password( STRING )
                .nickname( STRING )
                .email( STRING )
                .status( STRING )
                .role( getRoleModel() )
                .successfulAuth( INTEGER )
                .failedAuth( INTEGER )
                .passwordExpirationDate( NOW )
                .endBlockDate( NOW )
                .lastConnection( NOW )
                .audit( getAuditModel() )
                .build();
    }

    private static Administrator getAdministratorModel() {
        return Administrator.builder()
                .id( IDENTIFIER )
                .username( STRING )
                .password( STRING )
                .nickname( STRING )
                .email( STRING )
                .status( STRING )
                .role( getRoleModel() )
                .successfulAuth( INTEGER )
                .failedAuth( INTEGER )
                .passwordExpirationDate( NOW )
                .endBlockDate( NOW )
                .lastConnection( NOW )
                .audit( getAuditModel() )
                .personalInfo( getPersonalInfoModel() )
                .build();
    }

    private static Audit getAuditModel() {
        return Audit.builder()
                .creationDate( NOW )
                .createdBy( Administrator.builder().build() )
                .modificationDate( NOW )
                .modificationBy( Administrator.builder().build() )
                .deletionDate( NOW )
                .deletedBy( Administrator.builder().build() )
                .build();
    }

    private static PersonalInfo getPersonalInfoModel() {
        return PersonalInfo.builder()
                .document( getDocumentModel() )
                .name( STRING )
                .surnames( STRING )
                .gender( STRING )
                .birthdate( java.time.LocalDate.now() )
                .phone( getPhoneModel() )
                .build();
    }

    private static Document getDocumentModel() {
        return Document.builder()
                .type( STRING )
                .content( STRING )
                .build();
    }

    private static Phone getPhoneModel() {
        return Phone.builder()
                .countryCode( STRING )
                .number( STRING )
                .build();
    }

    private static Product getProductModel() {
        return Product.builder()
                .id( IDENTIFIER )
                .code( STRING )
                .name( STRING )
                .description( STRING )
                .brand( STRING )
                .model( STRING )
                // TODO: Change this
                .productImages( Stream.of(getImageModel()) )
                .price( BigDecimal.ZERO )
                .ratingNumber( INTEGER )
                .rating( BigDecimal.ZERO )
                .stock( INTEGER )
                .unitsSold( INTEGER )
                .upperLimit( INTEGER )
                .lowerLimit( INTEGER )
                .totalEarnings( BigDecimal.ZERO )
                .onSale( true )
                .onOffer( true )
                .isNew( true )
                .discount( BigDecimal.ZERO )
                .comments( STRING )
                .audit( getAuditModel() )
                .build();
    }

    private static Image getImageModel() {
        return Image.builder()
                .format( STRING )
                .fileName( STRING )
                .path( STRING )
                .description( STRING )
                .size( STRING )
                .build();
    }

}
