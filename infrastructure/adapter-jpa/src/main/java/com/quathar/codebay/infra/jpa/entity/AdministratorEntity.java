package com.quathar.codebay.infra.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <h1>Administrator Entity</h1>
 *
 * @since 2023-12-19
 * @version 1.0
 * @author Q
 */
@Entity
@Table(name = "Administrator")
@NoArgsConstructor
@Getter
@Setter
public class AdministratorEntity extends UserEntity {
}
