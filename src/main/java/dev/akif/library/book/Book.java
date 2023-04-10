package dev.akif.library.book;

import dev.akif.crud.CRUDModel;

import java.time.Instant;

public record Book(
        Long id,
        String isbn,
        String title,
        int version,
        Instant createdAt,
        Instant updatedAt,
        Instant deletedAt
) implements CRUDModel<Long> {
}
