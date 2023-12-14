package com.quathar.codebay.domain.manager;

import com.quathar.codebay.domain.model.Administrator;
import com.quathar.codebay.domain.model.Catalog;
import com.quathar.codebay.domain.model.Category;
import com.quathar.codebay.domain.model.Customer;
import com.quathar.codebay.domain.model.Order;
import com.quathar.codebay.domain.model.Product;
import com.quathar.codebay.domain.model.Promotion;
import com.quathar.codebay.domain.model.ShoppingCart;
import com.quathar.codebay.domain.model.Store;
import com.quathar.codebay.domain.model.Supplier;
import com.quathar.codebay.domain.model.SupplierOrder;
import com.quathar.codebay.domain.model.User;
import com.quathar.codebay.domain.model.Warning;
import com.quathar.codebay.domain.model.common.Address;
import com.quathar.codebay.domain.model.common.Audit;
import com.quathar.codebay.domain.model.common.BankCard;
import com.quathar.codebay.domain.model.common.Coordinates;
import com.quathar.codebay.domain.model.common.Image;
import com.quathar.codebay.domain.model.enumerator.Gender;
import com.quathar.codebay.domain.model.enumerator.UserStatus;
import com.quathar.codebay.domain.model.type.CustomerType;
import com.quathar.codebay.domain.model.type.DocumentType;
import com.quathar.codebay.domain.model.type.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
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

    public static <M> M getInstance(Class<M> clazz) {
        return clazz.cast(createInstance(clazz));
    }

    private static Object createInstance(Class<?> clazz) {
        return switch (clazz.getSimpleName()) {
            case "Administrator" -> getAdministratorModel();
            case "Catalog"       -> getCatalogModel();
            case "Category"      -> getCategoryModel();
            case "Customer"      -> getCustomerModel();
            case "Order"         -> getOrderModel();
            case "Product"       -> getProductModel();
            case "Promotion"     -> getPromotionModel();
            case "ShoppingCart"  -> getShoppingCartModel();
            case "Store"         -> getStoreModel();
            case "Supplier"      -> getSupplierModel();
            case "SupplierOrder" -> getSupplierOrderModel();
            case "User"          -> getUserModel();
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

    private static Administrator getAdministratorModel() {
        return Administrator.builder()
                .id( UUID.randomUUID() )
                .username( "sudo" )
                .password( "password" )
                .nickname( "nickname" )
                .email( "email" )
                .successfulAuth( 0 )
                .failedAuth( 0 )
                .lastConnection( LocalDateTime.now() )
                .releaseBlock( LocalDateTime.now() )
                .status( UserStatus.ACTIVE )
                .audit( getAuditModel() )
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

    private static Customer getCustomerModel() {
        return Customer.builder()
                .id( UUID.randomUUID() )
                .user( getUserModel() )
                .documentType( null )
                .document( "12345678A" )
                .name( "John" )
                .surnames( "Doe" )
                .gender( Gender.MALE )
                .birthdate( LocalDate.parse("1999-09-09") )
                .country( null )
                .phoneNumber( "+34 612 34 56 78" )
                .homeAddress( null )
                .addresses( null )
                .bankCards( null )
                .accumulatedExpenditure( BigDecimal.valueOf(56.25) )
                .type( null )
                .comments( "comments" )
                .license( true )
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

    private static User getUserModel() {
        return Administrator.builder()
                .id( UUID.randomUUID() )
                .username( "jdoe" )
                .password( "password" )
                .nickname( "John Doe" )
                .email( "jdoe@email.com" )
                .successfulAuth( 2 )
                .failedAuth( 1 )
                .lastConnection( LocalDateTime.now() )
                .releaseBlock( LocalDateTime.now() )
                .status( UserStatus.ACTIVE )
                .audit( getAuditModel() )
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
