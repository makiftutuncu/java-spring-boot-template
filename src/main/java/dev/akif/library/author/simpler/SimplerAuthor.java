package dev.akif.library.author.simpler;

import dev.akif.crud.simpler.SimplerModel;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

public record SimplerAuthor(
        UUID id,
        String name,
        LocalDate birthDate,
        int version,
        Instant createdAt,
        Instant updatedAt,
        Instant deletedAt
) implements SimplerModel<UUID> {
}
