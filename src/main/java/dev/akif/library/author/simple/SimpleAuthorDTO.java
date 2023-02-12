package dev.akif.library.author.simple;

import dev.akif.crud.simple.SimpleDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

public record SimpleAuthorDTO(
        @NotNull UUID id,
        @NotBlank String name,
        @NotNull LocalDate birthDate,
        @NotNull Instant createdAt,
        @NotNull Instant updatedAt
) implements SimpleDTO<UUID> {
}
