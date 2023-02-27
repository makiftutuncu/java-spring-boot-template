package dev.akif.library.author.simplest;

import dev.akif.crud.simplest.SimplestMapper;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SimplestAuthorMapper implements SimplestMapper<UUID, SimplestAuthorEntity> {
    @Override
    public void updateEntityWith(final SimplestAuthorEntity updateAuthorEntity, final SimplestAuthorEntity authorEntity) {
        authorEntity.setName(updateAuthorEntity.getName());
        authorEntity.setBirthDate(updateAuthorEntity.getBirthDate());
    }
}
