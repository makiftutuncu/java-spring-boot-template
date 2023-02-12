package dev.akif.library.author;

import dev.akif.crud.CRUDDTOMapper;
import dev.akif.crud.CRUDMapper;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.UUID;

@Component
public class AuthorMapper implements CRUDMapper<UUID, AuthorEntity, Author, CreateAuthor, UpdateAuthor>, CRUDDTOMapper<UUID, Author, AuthorDTO, CreateAuthor, UpdateAuthor, CreateAuthorDTO, UpdateAuthorDTO> {
    @Override
    public AuthorDTO modelToDTO(final Author author) {
        return new AuthorDTO(author.id(), author.name(), author.birthDate(), author.createdAt(), author.updatedAt());
    }

    @Override
    public CreateAuthor createDTOToCreateModel(final CreateAuthorDTO createAuthorDTO) {
        return new CreateAuthor(createAuthorDTO.name(), createAuthorDTO.birthDate());
    }

    @Override
    public UpdateAuthor updateDTOToUpdateModel(final UpdateAuthorDTO updateAuthorDTO) {
        return new UpdateAuthor(updateAuthorDTO.name(), updateAuthorDTO.birthDate());
    }

    @Override
    public AuthorEntity entityToBeCreatedFrom(final CreateAuthor createAuthor, final Instant now) {
        return new AuthorEntity(createAuthor.name(), createAuthor.birthDate(), now);
    }

    @Override
    public Author entityToModel(final AuthorEntity authorEntity) {
        return new Author(
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
    public void updateEntityWith(final UpdateAuthor updateAuthor, final AuthorEntity authorEntity) {
        authorEntity.setName(updateAuthor.name());
        authorEntity.setBirthDate(updateAuthor.birthDate());
    }
}
