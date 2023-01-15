package dev.akif.library.author.api;

import dev.akif.crud.CRUDController;
import dev.akif.library.author.data.AuthorEntity;
import dev.akif.library.author.data.AuthorRepository;
import dev.akif.library.author.dto.AuthorDTO;
import dev.akif.library.author.dto.CreateAuthorDTO;
import dev.akif.library.author.dto.UpdateAuthorDTO;
import dev.akif.library.author.model.Author;
import dev.akif.library.author.model.CreateAuthor;
import dev.akif.library.author.model.UpdateAuthor;
import dev.akif.library.author.service.AuthorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping("/v1/authors")
@RestController
@Tag(name = "Authors", description = "CRUD operations for author entities")
public class AuthorController extends CRUDController<
        UUID,
        AuthorDTO,
        Author,
        AuthorEntity,
        CreateAuthor,
        UpdateAuthor,
        CreateAuthorDTO,
        UpdateAuthorDTO,
        AuthorRepository,
        AuthorService> {
    public AuthorController(final AuthorService service) {
        super("Author", service);
    }

    @Override
    public AuthorDTO toDTO(final Author model) {
        return new AuthorDTO(
                model.id(),
                model.createdAt(),
                model.updatedAt(),
                model.name(),
                model.birthDate()
        );
    }
}
