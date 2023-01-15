package dev.akif.library.author.service;

import dev.akif.crud.CRUDService;
import dev.akif.library.author.data.AuthorEntity;
import dev.akif.library.author.data.AuthorRepository;
import dev.akif.library.author.model.Author;
import dev.akif.library.author.model.CreateAuthor;
import dev.akif.library.author.model.UpdateAuthor;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.util.UUID;

@Service
public class AuthorService extends CRUDService<UUID, Author, AuthorEntity, CreateAuthor, UpdateAuthor, AuthorRepository> {
    public AuthorService(final Clock clock, final AuthorRepository repository) {
        super("Author", clock, repository);
    }
}
