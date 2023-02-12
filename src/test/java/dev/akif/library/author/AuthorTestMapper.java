package dev.akif.library.author;

import dev.akif.crud.CRUDMapper;
import dev.akif.crud.CRUDTestMapper;

import java.util.UUID;

public class AuthorTestMapper extends AuthorMapper implements CRUDMapper<UUID, AuthorEntity, Author, CreateAuthor, UpdateAuthor>, CRUDTestMapper<UUID, AuthorEntity, Author, CreateAuthor, UpdateAuthor> {
    @Override
    public CreateAuthor entityToCreateModel(final AuthorEntity authorEntity) {
        return new CreateAuthor(authorEntity.getName(), authorEntity.getBirthDate());
    }

    @Override
    public Author entityToModelWithExpectedId(final AuthorEntity authorEntity, final UUID expectedId) {
        return new Author(
                expectedId,
                authorEntity.getName(),
                authorEntity.getBirthDate(),
                authorEntity.getVersion(),
                authorEntity.getCreatedAt(),
                authorEntity.getUpdatedAt(),
                authorEntity.getDeletedAt()
        );
    }
}
