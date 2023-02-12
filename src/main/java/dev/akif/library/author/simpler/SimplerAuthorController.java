package dev.akif.library.author.simpler;

import dev.akif.crud.simpler.SimplerController;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping("/v1/simpler/authors")
@RestController
@Tag(name = "Simpler Authors", description = "Simpler CRUD operations for author entities")
public class SimplerAuthorController extends SimplerController<
        UUID,
        SimplerAuthorEntity,
        SimplerAuthor,
        SimplerAuthorMapper,
        SimplerAuthorService> {
    public SimplerAuthorController(final SimplerAuthorService service, final SimplerAuthorMapper mapper) {
        super("SimplerAuthor", service, mapper);
    }
}
