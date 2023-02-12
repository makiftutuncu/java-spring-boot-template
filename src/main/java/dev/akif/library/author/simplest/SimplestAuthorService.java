package dev.akif.library.author.simplest;

import dev.akif.crud.simplest.SimplestService;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.util.UUID;

@Service
public class SimplestAuthorService extends SimplestService<UUID, SimplestAuthorEntity, SimplestAuthorMapper> {
    public SimplestAuthorService(final Clock clock, final SimplestAuthorRepository repository, final SimplestAuthorMapper mapper) {
        super("SimplestAuthor", clock, repository, mapper);
    }
}
