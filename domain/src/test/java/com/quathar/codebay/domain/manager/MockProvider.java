package com.quathar.codebay.domain.manager;

import com.quathar.codebay.domain.model.*;
import com.quathar.codebay.domain.model.common.Address;
import com.quathar.codebay.domain.model.common.Audit;
import com.quathar.codebay.domain.model.common.BankCard;
import com.quathar.codebay.domain.model.common.Coordinates;
import com.quathar.codebay.domain.model.common.Image;
import com.quathar.codebay.domain.model.enumerator.Gender;
import com.quathar.codebay.domain.model.security.*;
import com.quathar.codebay.domain.model.type.CustomerType;
import com.quathar.codebay.domain.model.type.DocumentType;
import com.quathar.codebay.domain.model.type.OrderStatus;
import com.quathar.codebay.domain.model.valueobject.PersonalInfo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * <h1>Model Provider</h1>
 * <br>
 * <p>
 *     Provides instances of different models.
 * </p>
 *
 * @since 2023-12-09
 * @version 1.0
 * @author Q
 */
public abstract class MockProvider {

    // <<-CONSTANTS->>
    private static final int INTEGER = 0;
    private static final String STRING = "string";
    private static final UUID IDENTIFIER = UUID.randomUUID();
    private static final LocalDateTime NOW = LocalDateTime.now();

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
            case "PersonalInfo"  -> getPersonalInfoValueObject();
            case "User"          -> getUserModel();
            case "Administrator" -> getAdministratorModel();
            case "Customer"      -> getCustomerModel();
            case "Catalog"       -> getCatalogModel();
            case "Category"      -> getCategoryModel();
            case "Order"         -> getOrderModel();
            case "Product"       -> getProductModel();
            case "Promotion"     -> getPromotionModel();
            case "ShoppingCart"  -> getShoppingCartModel();
            case "Store"         -> getStoreModel();
            case "Supplier"      -> getSupplierModel();
            case "SupplierOrder" -> getSupplierOrderModel();
            case "Warning"       -> getWarningModel();
            case "Audit"        -> getAuditModel();
            case "DocumentType" -> getDocumentTypeModel();
            case "Address"      -> getAddressModel();
            case "BankCard"     -> getBankCardModel();
            case "CustomerType" -> getCustomerTypeModel();
            case "Coordinates"  -> getCoordinatesModel();
            case "Image"        -> getImageModel();
            default -> null;
        };
    }

    // [ SECURITY ]
    private static Role getRoleModel() {
        return Role.builder()
                .id( IDENTIFIER )
                .name( STRING )
                .description( STRING )
                .grantedPermissions( List.of(GrantedPermission.builder().build()) )
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
                .operations( Set.of(STRING) )
                .build();
    }

    // [ USERS ]
    private static PersonalInfo getPersonalInfoValueObject() {
        return PersonalInfo.builder()
//                .document()
                .name( STRING )
                .surnames( STRING )
                .gender( STRING )
                .birthdate( NOW.toLocalDate() )
//                .phone()
                .build();
    }

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
                .creationDate( NOW )
                .passwordExpirationDate( NOW )
                .endBlockDate( NOW )
                .lastConnection( NOW )
//                .audit( getAuditModel() )
                .build();
    }

    private static Administrator getAdministratorModel() {
        return Administrator.builder()
                .personalInfo( getPersonalInfoValueObject() )
                .build();
    }

    private static Customer getCustomerModel() {
        return Customer.builder()
                .personalInfo( getPersonalInfoValueObject() )
                .country( null )
                .homeAddress( null )
                .addresses( null )
                .bankCards( null )
                .accumulatedExpenditure( BigDecimal.valueOf(56.25) )
                .type( null )
                .comments( STRING )
                .license( true )
                .build();
    }

    private static Catalog getCatalogModel() {
        return Catalog.builder()
                .id( UUID.randomUUID() )
                .build();
    }

    private static Category getCategoryModel() {
        Category otherCategory = Category.builder()
                .id( UUID.randomUUID() )
                .code( "other code" )
                .description( "other description" )
                .audit( getAuditModel() )
                .build();

        return Category.builder()
                .id( UUID.randomUUID() )
                .code( "code" )
                .description( "description" )
                .parentCategory( otherCategory )
                .childCategories( Set.of(otherCategory) )
                .audit( getAuditModel() )
                .build();
    }

    private static Order getOrderModel() {
        return Order.builder()
                .id( UUID.randomUUID() )
                .customer( getCustomerModel() )
                .date( LocalDateTime.now() )
                .totalPrice( BigDecimal.ONE )
                .status( OrderStatus.builder().build() )
                .build();
    }

    private static Product getProductModel() {
        return Product.builder()
                .id( UUID.randomUUID() )
                .code( "X382KD" )
                .name( "Test Product" )
                .description( "A test product" )
                .brand( "ProductMasters" )
                .model( "ProductA" )
                .productImages( null )
                .price( BigDecimal.valueOf(6.25) )
                .ratingNumber( 2 )
                .rating( BigDecimal.valueOf(2.5) )
                .stock( 18 )
                .unitsSold( 2 )
                .upperLimit( 10 )
                .lowerLimit( 5 )
                .totalEarnings( BigDecimal.valueOf(12.5) )
                .onSale( true )
                .onOffer( false )
                .isNew( true )
                .discount( BigDecimal.ZERO )
                .comments( "comments" )
                .audit( getAuditModel() )
                .build();
    }

    private static Promotion getPromotionModel() {
        return Promotion.builder()
                .id( UUID.randomUUID() )
                .build();
    }

    private static ShoppingCart getShoppingCartModel() {
        return ShoppingCart.builder()
                .id( UUID.randomUUID() )
                .build();
    }

    private static Store getStoreModel() {
        return Store.builder()
                .id( UUID.randomUUID() )
                .build();
    }

    private static Supplier getSupplierModel() {
        return Supplier.builder()
                .id( UUID.randomUUID() )
                .build();
    }

    private static SupplierOrder getSupplierOrderModel() {
        return SupplierOrder.builder()
                .id( UUID.randomUUID() )
                .build();
    }

    private static Warning getWarningModel() {
        return Warning.builder()
                .id( UUID.randomUUID() )
                .description( "description" )
                .urgency( null )
                .processingDate( LocalDateTime.now() )
                .processedBy( getAdministratorModel() )
                .build();
    }

    private static Audit getAuditModel() {
        return Audit.builder().build();
    }

    private static DocumentType getDocumentTypeModel() {
        return DocumentType.builder().build();
    }

    private static Address getAddressModel() {
        return Address.builder().build();
    }

    private static BankCard getBankCardModel() {
        return BankCard.builder().build();
    }

    private static CustomerType getCustomerTypeModel() {
        return CustomerType.builder().build();
    }

    private static Coordinates getCoordinatesModel() {
        return Coordinates.builder().build();
    }

    private static Image getImageModel() {
        return Image.builder().build();
    }

}
