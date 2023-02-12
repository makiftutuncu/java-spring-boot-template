package dev.akif.library.author.simplest;

import dev.akif.crud.simplest.SimplestController;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping("/v1/simplest/authors")
@RestController
@Tag(name = "Simplest Authors", description = "Simplest CRUD operations for author entities")
public class SimplestAuthorController extends SimplestController<
        UUID,
        SimplestAuthorEntity,
        SimplestAuthorMapper,
        SimplestAuthorService> {
    public SimplestAuthorController(final SimplestAuthorService service, final SimplestAuthorMapper mapper) {
        super("SimplestAuthor", service, mapper);
    }
}
