package dev.akif.library.authorbook;

import dev.akif.crud.CRUDModel;
import dev.akif.library.author.Author;
import dev.akif.library.book.Book;
import org.jetbrains.annotations.Nullable;

import java.time.Instant;
import java.util.List;

public record BookWithAuthors(Book book, List<Author> authors) implements CRUDModel<Long> {
    @Override
    public Long id() {
        return book.id();
    }

    @Override
    public int version() {
        return book.version();
    }

    @Override
    public Instant createdAt() {
        return book.createdAt();
    }

    @Nullable
    @Override
    public Instant deletedAt() {
        return book.deletedAt();
    }

    @Override
    public Instant updatedAt() {
        return book.updatedAt();
    }
}
