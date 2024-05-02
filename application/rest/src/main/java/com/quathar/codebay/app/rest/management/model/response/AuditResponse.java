package com.quathar.codebay.app.rest.management.model.response;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * <h1>Audit Response</h1>
 *
 * @param creationDate     The date and time when the entity was created.
 * @param createdBy        The administrator who created the entity.
 * @param modificationDate The date and time when the entity was last modified.
 * @param modificationBy   The administrator who last modified the entity.
 * @param deletionDate     The date and time when the entity was deleted.
 * @param deletedBy        The administrator who deleted the entity.
 *
 * @since 2024-04-28
 * @version 1.0
 * @author Q
 */
public record AuditResponse(
        LocalDateTime creationDate,
        Admin         createdBy,
        LocalDateTime modificationDate,
        Admin         modificationBy,
        LocalDateTime deletionDate,
        Admin         deletedBy
) {
    public record Admin(UUID id, String username) {}
}
