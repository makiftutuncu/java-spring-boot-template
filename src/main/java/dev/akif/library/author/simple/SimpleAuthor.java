package dev.akif.library.author.simple;

import dev.akif.crud.simple.SimpleModel;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

public record SimpleAuthor(
        UUID id,
        String name,
        LocalDate birthDate,
        int version,
        Instant createdAt,
        Instant updatedAt,
        Instant deletedAt
) implements SimpleModel<UUID> {
}
