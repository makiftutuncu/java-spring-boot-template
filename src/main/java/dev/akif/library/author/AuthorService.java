package dev.akif.library.author;

import dev.akif.crud.CRUDRepository;
import dev.akif.crud.CRUDService;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.util.UUID;

@Service
public class AuthorService extends CRUDService<UUID, AuthorEntity, Author, CreateAuthor, UpdateAuthor, AuthorMapper> {
    public AuthorService(final Clock clock, final CRUDRepository<UUID, AuthorEntity> repository, final AuthorMapper mapper) {
        super("Author", clock, repository, mapper);
    }
}
