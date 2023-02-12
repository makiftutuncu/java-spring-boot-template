package dev.akif.library.author;

import dev.akif.crud.CRUDRepository;
import dev.akif.crud.CRUDServiceTest;
import org.junit.jupiter.api.DisplayName;

import java.time.Clock;
import java.util.UUID;
import java.util.function.BiPredicate;

@DisplayName("AuthorService")
class AuthorServiceTest extends CRUDServiceTest<UUID, Author, AuthorEntity, CreateAuthor, UpdateAuthor, AuthorMapper, AuthorTestMapper, AuthorService> {
    private static final BiPredicate<AuthorEntity, AuthorEntity> duplicateCheck = (e1, e2) ->
            e1.getName().equals(e2.getName())
                    && e1.getBirthDate().equals(e2.getBirthDate());

    private static final AuthorEntity author1 = new AuthorEntity(
            UUID.randomUUID(),
            "Author 1",
            getToday(),
            0,
            getNow(),
            getNow(),
            null
    );

    private static final AuthorEntity author2 = new AuthorEntity(
            UUID.randomUUID(),
            "Author 2",
            getToday().plusDays(1),
            0,
            getNow(),
            getNow(),
            null
    );

    private static final AuthorEntity author3 = new AuthorEntity(
            UUID.randomUUID(),
            "Author 3",
            getToday().plusDays(2),
            0,
            getNow(),
            getNow(),
            null
    );

    private static final AuthorTestMapper mapper = new AuthorTestMapper();

    public AuthorServiceTest() {
        super("Author", mapper, mapper, duplicateCheck, author1, author2, author3);
    }

    @Override
    protected AuthorService buildService(
            final Clock clock,
            final CRUDRepository<UUID, AuthorEntity> repository,
            final AuthorMapper mapper
    ) {
        return new AuthorService(clock, repository, mapper);
    }
}
