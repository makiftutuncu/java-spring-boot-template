package dev.akif.library.author.model;

import dev.akif.crud.BaseModel;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

public record Author(
        UUID id,
        int version,
        Instant createdAt,
        Instant updatedAt,
        String name,
        LocalDate birthDate
) implements BaseModel<UUID> {
}
