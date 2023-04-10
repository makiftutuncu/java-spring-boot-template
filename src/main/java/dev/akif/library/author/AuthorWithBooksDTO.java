package dev.akif.library.author;

import dev.akif.crud.CRUDDTO;
import dev.akif.library.book.BookDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record AuthorWithBooksDTO(
        @NotNull UUID id,
        @NotBlank String name,
        @NotNull List<BookDTO> books,
        @NotNull LocalDate birthDate,
        @NotNull Instant createdAt,
        @NotNull Instant updatedAt
) implements CRUDDTO<UUID> {
    public AuthorDTO withoutBooks() {
        return new AuthorDTO(id, name, birthDate, createdAt, updatedAt);
    }
}
