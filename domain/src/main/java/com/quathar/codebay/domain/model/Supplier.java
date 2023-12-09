package com.quathar.codebay.domain.model;

import com.quathar.codebay.domain.model.common.Address;
import com.quathar.codebay.domain.model.common.Audit;
import com.quathar.codebay.domain.model.type.DocumentType;
import com.quathar.codebay.domain.model.type.SupplierType;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.net.URL;
import java.util.UUID;

/**
 * <h1>Supplier Model</h1>
 *
 * @since 2023-03-27
 * @version 2.0
 * @author Q
 */
@Builder
@Getter
@Setter
public class Supplier {

    // <<-FIELDS->>
    private UUID         id;
    private DocumentType documentType;
    private String       document;
    private String       name;
    private Address      address;
    private String       email;
    private String       phoneNumber;
    private String       landlineNumber;
    private SupplierType type;
    private String       comments;
    private URL          web;
    private Audit        audit;

}
