package dev.akif.library.book;

import dev.akif.crud.CRUDDTO;
import dev.akif.library.author.AuthorDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;
import java.util.List;

public record BookWithAuthorsDTO(
        @NotNull Long id,
        @NotNull String isbn,
        @NotBlank String title,
        @NotNull List<AuthorDTO> authors,
        @NotNull Instant createdAt,
        @NotNull Instant updatedAt
) implements CRUDDTO<Long> {
}
