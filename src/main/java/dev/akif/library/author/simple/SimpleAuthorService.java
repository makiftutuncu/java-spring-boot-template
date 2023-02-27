package dev.akif.library.author.simple;

import dev.akif.crud.CRUDRepository;
import dev.akif.crud.common.InstantProvider;
import dev.akif.crud.simple.SimpleService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SimpleAuthorService extends SimpleService<UUID, SimpleAuthorEntity, SimpleAuthor, SimpleAuthorDTO, SimpleAuthorRepository, SimpleAuthorMapper> {
    public SimpleAuthorService(final InstantProvider instantProvider,
                               final CRUDRepository<UUID, SimpleAuthorEntity> repository,
                               final SimpleAuthorMapper mapper) {
        super("SimpleAuthor", instantProvider, repository, mapper);
    }
}
