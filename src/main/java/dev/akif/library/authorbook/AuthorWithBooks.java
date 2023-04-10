package dev.akif.library.authorbook;

import dev.akif.crud.CRUDModel;
import dev.akif.library.author.Author;
import dev.akif.library.book.Book;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public record AuthorWithBooks(Author author, List<Book> books) implements CRUDModel<UUID> {
    @Override
    public UUID id() {
        return author.id();
    }

    @Override
    public int version() {
        return author.version();
    }

    @Override
    public Instant createdAt() {
        return author.createdAt();
    }

    @Nullable
    @Override
    public Instant deletedAt() {
        return author.deletedAt();
    }

    @Override
    public Instant updatedAt() {
        return author.updatedAt();
    }
}
