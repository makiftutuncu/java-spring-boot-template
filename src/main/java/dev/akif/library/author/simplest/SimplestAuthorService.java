package dev.akif.library.author.simplest;

import dev.akif.crud.common.InstantProvider;
import dev.akif.crud.simplest.SimplestService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SimplestAuthorService extends SimplestService<UUID, SimplestAuthorEntity, SimplestAuthorMapper> {
    public SimplestAuthorService(final InstantProvider instantProvider, final SimplestAuthorRepository repository, final SimplestAuthorMapper mapper) {
        super("SimplestAuthor", instantProvider, repository, mapper);
    }
}
