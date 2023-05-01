package dev.akif.library.author;

import dev.akif.crud.CRUDServiceTest;
import dev.akif.library.authorbook.AuthorWithBooks;
import org.junit.jupiter.api.DisplayName;

import java.util.UUID;

@DisplayName("AuthorService")
class AuthorServiceTest extends CRUDServiceTest<UUID, AuthorEntity, AuthorWithBooks, CreateAuthor, UpdateAuthor, AuthorMapper, AuthorRepository, AuthorService, AuthorTestData> {
    public AuthorServiceTest() {
        super(
                new AuthorMapper(),
                AuthorTestHelper.INSTANCE.testData,
                (mapper, testData) -> new AuthorService(testData.getInstantProvider(), AuthorTestHelper.INSTANCE.repository, mapper)
        );
    }

    @Override
    protected void resetData() {
        AuthorTestHelper.INSTANCE.repository.reset();
    }
}
