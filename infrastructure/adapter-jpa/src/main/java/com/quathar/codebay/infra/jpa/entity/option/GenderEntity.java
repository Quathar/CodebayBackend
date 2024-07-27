package com.quathar.codebay.infra.jpa.entity.option;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * <h1>Gender Entity</h1>
 *
 * @see BaseOptionEntity
 * @since 2023-05-18
 * @version 1.0
 * @author Q
 */
@Entity
@Table(name = "Gender")
public final class GenderEntity extends BaseOptionEntity {
}
