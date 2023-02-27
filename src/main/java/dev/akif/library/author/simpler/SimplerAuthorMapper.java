package dev.akif.library.author.simpler;

import dev.akif.crud.simpler.SimplerMapper;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.UUID;

@Component
public class SimplerAuthorMapper implements SimplerMapper<UUID, SimplerAuthorEntity, SimplerAuthor> {
    @Override
    public SimplerAuthorEntity entityToBeCreatedFrom(final SimplerAuthor author, final Instant now) {
        return new SimplerAuthorEntity(author.name(), author.birthDate(), now);
    }

    @Override
    public SimplerAuthor entityToModel(final SimplerAuthorEntity authorEntity) {
        return new SimplerAuthor(
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
    public void updateEntityWith(final SimplerAuthorEntity authorEntity, final SimplerAuthor author) {
        authorEntity.setName(author.name());
        authorEntity.setBirthDate(author.birthDate());
    }
}
