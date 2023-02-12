package dev.akif.library.author;

import dev.akif.crud.CRUDDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

public record AuthorDTO(
        @NotNull UUID id,
        @NotBlank String name,
        @NotNull LocalDate birthDate,
        @NotNull Instant createdAt,
        @NotNull Instant updatedAt
) implements CRUDDTO<UUID> {
}
