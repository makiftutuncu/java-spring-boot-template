package dev.akif.library.author.simplest;

import dev.akif.crud.CRUDRepository;
import dev.akif.crud.common.InstantProvider;
import dev.akif.crud.simplest.SimplestService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SimplestAuthorService extends SimplestService<UUID, SimplestAuthorEntity, SimplestAuthorRepository, SimplestAuthorMapper> {
    public SimplestAuthorService(final InstantProvider instantProvider,
                                 final CRUDRepository<UUID, SimplestAuthorEntity> repository,
                                 final SimplestAuthorMapper mapper) {
        super("SimplestAuthor", instantProvider, repository, mapper);
    }
}
