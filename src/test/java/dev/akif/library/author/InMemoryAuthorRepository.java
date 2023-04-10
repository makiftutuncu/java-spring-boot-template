package dev.akif.library.author;

import dev.akif.crud.InMemoryCRUDRepository;

import java.util.UUID;

public final class InMemoryAuthorRepository extends InMemoryCRUDRepository<UUID, AuthorEntity, CreateAuthor, AuthorTestData> implements AuthorRepository {
    public InMemoryAuthorRepository(final AuthorTestData testData) {
        super(testData);
    }
}
