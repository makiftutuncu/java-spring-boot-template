package dev.akif.library.author.simple;

import dev.akif.crud.simple.SimpleController;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping("/simple/authors")
@RestController
@Tag(name = "Simple Authors", description = "Simple CRUD operations for author entities")
public class SimpleAuthorController extends SimpleController<
        UUID,
        SimpleAuthorEntity,
        SimpleAuthor,
        SimpleAuthorDTO,
        SimpleAuthorMapper,
        SimpleAuthorRepository,
        SimpleAuthorService> {
    public SimpleAuthorController(final SimpleAuthorService service, final SimpleAuthorMapper mapper) {
        super("SimpleAuthor", service, mapper);
    }
}
