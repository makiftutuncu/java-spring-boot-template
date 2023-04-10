package dev.akif.library.author;

import dev.akif.crud.CRUDTestData;
import dev.akif.crud.IdGenerator;
import dev.akif.crud.InMemoryCRUDRepository;
import dev.akif.crud.common.Paged;
import dev.akif.crud.common.Parameters;
import dev.akif.library.authorbook.AuthorWithBooks;
import kotlin.Pair;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.List;
import java.util.UUID;

public final class AuthorTestData extends CRUDTestData<UUID, AuthorEntity, AuthorWithBooks, CreateAuthor, UpdateAuthor, AuthorTestData> {
    public final LocalDate today = LocalDate.ofInstant(now(), ZoneOffset.UTC);

    public final AuthorEntity authorEntity1 = new AuthorEntity(
            "Author 1",
            today,
            now()
    );

    public final AuthorEntity authorEntity2 = new AuthorEntity(
            "Author 2",
            today.plusDays(1),
            now().plusSeconds(1)
    );

    public final AuthorEntity authorEntity3 = new AuthorEntity(
            "Author 3",
            today.plusDays(2),
            now().plusSeconds(2)
    );

    public AuthorTestData() {
        super("Author");
        authorEntity1.setId(UUID.randomUUID());
        authorEntity2.setId(UUID.randomUUID());
        authorEntity3.setId(UUID.randomUUID());
    }

    @Override
    public InMemoryCRUDRepository<UUID, AuthorEntity, CreateAuthor, AuthorTestData> getRepository() {
        return AuthorTestHelper.INSTANCE.repository;
    }

    @Override
    public IdGenerator<UUID> getIdGenerator() {
        return IdGenerator.uuid;
    }

    @Override
    public AuthorEntity getTestEntity1() {
        return authorEntity1;
    }

    @Override
    public AuthorEntity getTestEntity2() {
        return authorEntity2;
    }

    @Override
    public AuthorEntity getTestEntity3() {
        return authorEntity3;
    }

    @Override
    public AuthorEntity[] getMoreTestEntities() {
        return new AuthorEntity[0];
    }

    @Override
    public List<AuthorEntity> getDefaultFirstPageEntities() {
        return List.of(authorEntity1, authorEntity2, authorEntity3);
    }

    @Override
    public List<Pair<PageRequest, Paged<AuthorEntity>>> getPaginationTestCases() {
        return List.of(
                new Pair<>(
                        PageRequest.of(0, 2),
                        new Paged<>(List.of(authorEntity1, authorEntity2), 0, 2, 2)
                ),
                new Pair<>(
                        PageRequest.of(1, 2),
                        new Paged<>(List.of(authorEntity3), 1, 2, 2)
                ),
                new Pair<>(
                        PageRequest.of(2, 2),
                        new Paged<>(List.of(), 2, 2, 2)
                )
        );
    }

    @Override
    public Parameters getTestParameters() {
        return Parameters.empty;
    }

    @Override
    public boolean areDuplicates(final AuthorEntity e1, final AuthorEntity e2) {
        return e1.getName().equals(e2.getName())
                && e1.getBirthDate().equals(e2.getBirthDate())
                && e1.getBooks().equals(e2.getBooks());
    }

    @Override
    public AuthorEntity copy(final AuthorEntity authorEntity) {
        return new AuthorEntity(
                authorEntity.getId(),
                authorEntity.getName(),
                authorEntity.getBirthDate(),
                authorEntity.getBooks(),
                authorEntity.getVersion(),
                authorEntity.getCreatedAt(),
                authorEntity.getUpdatedAt(),
                authorEntity.getDeletedAt()
        );
    }

    @Override
    public CreateAuthor entityToCreateModel(final AuthorEntity authorEntity) {
        return new CreateAuthor(authorEntity.getName(), authorEntity.getBirthDate());
    }

    @Override
    public UpdateAuthor entityToUpdateModelWithModifications(final AuthorEntity authorEntity) {
        return new UpdateAuthor(authorEntity.getName() + "-updated", authorEntity.getBirthDate().plusDays(1));
    }

    @Override
    public UpdateAuthor entityToUpdateModelWithNoModifications(final AuthorEntity authorEntity) {
        return new UpdateAuthor(authorEntity.getName(), authorEntity.getBirthDate());
    }
}
