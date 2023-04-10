package dev.akif.library.book;

import dev.akif.crud.CRUDController;
import dev.akif.crud.common.Paged;
import dev.akif.crud.common.Parameters;
import dev.akif.library.author.AuthorDTO;
import dev.akif.library.authorbook.AuthorBookService;
import dev.akif.library.authorbook.BookWithAuthors;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/books")
@RestController
@Tag(name = "Books", description = "CRUD operations for books")
public class BookController extends CRUDController<
        Long,
        BookEntity,
        BookWithAuthors,
        BookWithAuthorsDTO,
        CreateBook,
        UpdateBook,
        CreateBookDTO,
        UpdateBookDTO,
        BookMapper,
        BookDTOMapper,
        BookRepository,
        BookService> {
    private final AuthorBookService authorBookService;

    private static final String LIST_AUTHORS_SUMMARY = "List authors of books";
    private static final String LIST_AUTHORS_DESCRIPTION = "List authors of book with given pagination.";
    private static final String LIST_AUTHORS_RESPONSE = "Authors of book are returned successfully.";

    public BookController(final BookService service, final BookDTOMapper mapper, final AuthorBookService authorBookService) {
        super("Book", service, mapper);
        this.authorBookService = authorBookService;
    }

    @ApiResponse(responseCode = CODE_OK, description = LIST_AUTHORS_RESPONSE)
    @GetMapping(path = "/{id}/authors", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = LIST_AUTHORS_SUMMARY, description = LIST_AUTHORS_DESCRIPTION)
    public Paged<AuthorDTO> listAuthorsOfBook(
            @Parameter(name = "id", in = ParameterIn.PATH, description = GET_ID_DESCRIPTION)
            @PathVariable("id")
            final long bookId,
            @Parameter(name = "page", description = PAGE_DESCRIPTION)
            @RequestParam(name = "page", required = false, defaultValue = "0")
            final int page,
            @Parameter(name = "perPage", description = PER_PAGE_DESCRIPTION)
            @RequestParam(name = "perPage", required = false, defaultValue = "20")
            final int perPage,
            @Parameter(hidden = true)
            @PathVariable
            final Map<String, String> pathVariables,
            @Parameter(hidden = true)
            HttpServletRequest request
    ) {
        final var parameters = new Parameters(pathVariables, request);
        final var pageRequest = PageRequest.of(page, perPage);
        return authorBookService
                .listAuthorsOfBook(bookId, pageRequest, parameters)
                .map(a -> getMapper().authorToAuthorDTO(a));
    }
}
