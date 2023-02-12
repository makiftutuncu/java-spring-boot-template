package dev.akif.library.author.simplest;

import dev.akif.crud.simplest.SimplestMapper;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.UUID;

@Component
public class SimplestAuthorMapper implements SimplestMapper<UUID, SimplestAuthorEntity> {
    @Override
    public SimplestAuthorEntity createDTOToCreateModel(final SimplestAuthorEntity authorEntity) {
        return new SimplestAuthorEntity(authorEntity.getName(), authorEntity.getBirthDate(), null);
    }

    @Override
    public SimplestAuthorEntity updateDTOToUpdateModel(final SimplestAuthorEntity authorEntity) {
        return new SimplestAuthorEntity(authorEntity.getName(), authorEntity.getBirthDate(), null);
    }

    @Override
    public SimplestAuthorEntity entityToBeCreatedFrom(final SimplestAuthorEntity authorEntity, final Instant now) {
        return new SimplestAuthorEntity(authorEntity.getName(), authorEntity.getBirthDate(), now);
    }

    @Override
    public void updateEntityWith(final SimplestAuthorEntity updateAuthorEntity, final SimplestAuthorEntity authorEntity) {
        authorEntity.setName(updateAuthorEntity.getName());
        authorEntity.setBirthDate(updateAuthorEntity.getBirthDate());
    }
}
