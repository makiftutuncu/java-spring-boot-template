package dev.akif.library.author.dto;

import dev.akif.crud.BaseDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

public record AuthorDTO(
        @NotNull UUID id,
        @NotNull Instant createdAt,
        @NotNull Instant updatedAt,
        @NotBlank String name,
        @NotNull LocalDate birthDate
) implements BaseDTO<UUID> {
}
