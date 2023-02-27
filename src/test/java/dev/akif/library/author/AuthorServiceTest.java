package dev.akif.library.author;

import dev.akif.crud.CRUDRepository;
import dev.akif.crud.CRUDServiceTest;
import org.junit.jupiter.api.DisplayName;

import java.util.UUID;

@DisplayName("AuthorService")
class AuthorServiceTest extends CRUDServiceTest<UUID, AuthorEntity, Author, CreateAuthor, UpdateAuthor, AuthorMapper, AuthorRepository, AuthorService, AuthorTestData> {
    public AuthorServiceTest() {
        super(
                "Author",
                new AuthorMapper(),
                new AuthorTestData()
        );
    }

    @Override
    protected AuthorService buildService(final CRUDRepository<UUID, AuthorEntity> repository, final AuthorMapper mapper) {
        return new AuthorService(getTestData().getInstantProvider(), repository, mapper);
    }
}
