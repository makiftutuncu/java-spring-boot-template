package dev.akif.library.book;

import dev.akif.crud.InMemoryCRUDRepository;

public final class InMemoryBookRepository extends InMemoryCRUDRepository<Long, BookEntity, CreateBook, BookTestData> implements BookRepository {
    public InMemoryBookRepository(final BookTestData testData) {
        super(testData);
    }
}
