package com.quathar.codebay.app.rest.shop.model.response;

import com.quathar.codebay.app.rest.common.model.response.OrderDetailResponse;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.stream.Stream;

/**
 * <h1>Basic Order Response</h1>
 *
 * @param orderId      The order unique identifier.
 * @param username     The customer username.
 * @param status       The status of the order.
 * @param totalPrice   The total price of the order.
 * @param creationDate The date and time when the order was created.
 * @param deliveryDate The date and time when the order was delivered.
 * @param details      The details of the items in the order.
 *
 * @since 2024-05-08
 * @version 1.0
 * @author Q
 */
public record BasicOrderResponse(
        UUID                        orderId,
        String                      username,
        String                      status,
        BigDecimal                  totalPrice,
        LocalDateTime               creationDate,
        LocalDateTime               deliveryDate,
        Stream<OrderDetailResponse> details
) {}
