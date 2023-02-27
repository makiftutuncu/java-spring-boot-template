package dev.akif.library.author;

import dev.akif.crud.CRUDRepository;
import dev.akif.crud.CRUDService;
import dev.akif.crud.common.InstantProvider;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AuthorService extends CRUDService<UUID, AuthorEntity, Author, CreateAuthor, UpdateAuthor, AuthorRepository, AuthorMapper> {
    public AuthorService(final InstantProvider instantProvider,
                         final CRUDRepository<UUID, AuthorEntity> repository,
                         final AuthorMapper mapper) {
        super("Author", instantProvider, repository, mapper);
    }
}
