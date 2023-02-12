package dev.akif.library.author.simple;

import dev.akif.crud.simple.SimpleMapper;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.UUID;

@Component
public class SimpleAuthorMapper implements SimpleMapper<UUID, SimpleAuthorEntity, SimpleAuthor, SimpleAuthorDTO> {
    @Override
    public SimpleAuthorDTO modelToDTO(final SimpleAuthor author) {
        return new SimpleAuthorDTO(author.id(), author.name(), author.birthDate(), author.createdAt(), author.updatedAt());
    }

    @Override
    public SimpleAuthor createDTOToCreateModel(final SimpleAuthorDTO authorDTO) {
        return new SimpleAuthor(null, authorDTO.name(), authorDTO.birthDate(), 0, null, null, null);
    }

    @Override
    public SimpleAuthor updateDTOToUpdateModel(final SimpleAuthorDTO authorDTO) {
        return new SimpleAuthor(null, authorDTO.name(), authorDTO.birthDate(), 0, null, null, null);
    }

    @Override
    public SimpleAuthorEntity entityToBeCreatedFrom(final SimpleAuthor author, final Instant now) {
        return new SimpleAuthorEntity(author.name(), author.birthDate(), now);
    }

    @Override
    public SimpleAuthor entityToModel(final SimpleAuthorEntity authorEntity) {
        return new SimpleAuthor(
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
    public void updateEntityWith(final SimpleAuthor author, final SimpleAuthorEntity authorEntity) {
        authorEntity.setName(author.name());
        authorEntity.setBirthDate(author.birthDate());
    }
}
