package com.quathar.codebay.infra.outputadapter.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

/**
 * <h1>User Entity</h1>
 *
 * @since 2023-12-10
 * @version 1.0
 * @author Q
 */
@Entity
@Table(name = "Users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    // TODO: Add all the fields necessary for persistence

}
