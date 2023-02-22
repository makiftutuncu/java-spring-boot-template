package dev.akif.library.author.simpler;

import dev.akif.crud.common.InstantProvider;
import dev.akif.crud.simpler.SimplerService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SimplerAuthorService extends SimplerService<UUID, SimplerAuthorEntity, SimplerAuthor, SimplerAuthorMapper> {
    public SimplerAuthorService(final InstantProvider instantProvider, final SimplerAuthorRepository repository, final SimplerAuthorMapper mapper) {
        super("SimplerAuthor", instantProvider, repository, mapper);
    }
}
