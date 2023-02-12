package dev.akif.library.author;

import dev.akif.crud.CRUDModel;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

public record Author(
        UUID id,
        String name,
        LocalDate birthDate,
        int version,
        Instant createdAt,
        Instant updatedAt,
        Instant deletedAt
) implements CRUDModel<UUID> {
}
