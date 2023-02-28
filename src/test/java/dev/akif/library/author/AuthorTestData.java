package dev.akif.library.author;

import dev.akif.crud.CRUDTestData;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.UUID;

public class AuthorTestData extends CRUDTestData<UUID, AuthorEntity, Author, CreateAuthor, UpdateAuthor, AuthorTestData> {
    public final LocalDate today = LocalDate.ofInstant(getNow(), ZoneOffset.UTC);

    public final AuthorEntity authorEntity1 = new AuthorEntity(
            UUID.randomUUID(),
            "Author 1",
            today,
            0,
            getNow(),
            getNow(),
            null
    );

    public final AuthorEntity authorEntity2 = new AuthorEntity(
            UUID.randomUUID(),
            "Author 2",
            today.plusDays(1),
            0,
            getNow().plusSeconds(1),
            getNow().plusSeconds(1),
            null
    );

    public final AuthorEntity authorEntity3 = new AuthorEntity(
            UUID.randomUUID(),
            "Author 3",
            today.plusDays(2),
            0,
            getNow().plusSeconds(2),
            getNow().plusSeconds(2),
            null
    );

    public AuthorTestData() {
        super("Author");
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
    public boolean areDuplicates(final AuthorEntity e1, final AuthorEntity e2) {
        return e1.getName().equals(e2.getName())
                && e1.getBirthDate().equals(e2.getBirthDate());
    }

    @Override
    public AuthorEntity copy(final AuthorEntity authorEntity) {
        return new AuthorEntity(
                authorEntity.getId(),
                authorEntity.getName(),
                authorEntity.getBirthDate(),
                authorEntity.getVersion(),
                authorEntity.getCreatedAt(),
                authorEntity.getUpdatedAt(),
                authorEntity.getDeletedAt()
        );
    }

    @Override
    public UUID randomId() {
        return UUID.randomUUID();
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
