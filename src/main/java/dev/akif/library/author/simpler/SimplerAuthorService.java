package dev.akif.library.author.simpler;

import dev.akif.crud.simpler.SimplerService;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.util.UUID;

@Service
public class SimplerAuthorService extends SimplerService<UUID, SimplerAuthorEntity, SimplerAuthor, SimplerAuthorMapper> {
    public SimplerAuthorService(final Clock clock, final SimplerAuthorRepository repository, final SimplerAuthorMapper mapper) {
        super("SimplerAuthor", clock, repository, mapper);
    }
}
