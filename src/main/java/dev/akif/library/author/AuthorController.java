package dev.akif.library.author;

import dev.akif.crud.CRUDController;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping("/authors")
@RestController
@Tag(name = "Authors", description = "CRUD operations for author entities")
public class AuthorController extends CRUDController<
        UUID,
        AuthorEntity,
        Author,
        AuthorDTO,
        CreateAuthor,
        UpdateAuthor,
        CreateAuthorDTO,
        UpdateAuthorDTO,
        AuthorMapper,
        AuthorMapper,
        AuthorRepository,
        AuthorService> {
    public AuthorController(final AuthorService service, final AuthorMapper mapper) {
        super("Author", service, mapper);
    }
}
