package dev.akif.library.book;

import dev.akif.crud.CRUDDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;

public record BookDTO(
        @NotNull Long id,
        @NotNull String isbn,
        @NotBlank String title,
        @NotNull Instant createdAt,
        @NotNull Instant updatedAt
) implements CRUDDTO<Long> {
}
