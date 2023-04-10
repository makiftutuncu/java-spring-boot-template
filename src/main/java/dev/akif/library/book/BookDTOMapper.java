package dev.akif.library.book;

import dev.akif.crud.CRUDDTOMapper;
import dev.akif.crud.common.Parameters;
import dev.akif.library.author.Author;
import dev.akif.library.author.AuthorDTO;
import dev.akif.library.authorbook.BookWithAuthors;
import org.springframework.stereotype.Component;

@Component
public class BookDTOMapper implements CRUDDTOMapper<Long, BookWithAuthors, BookWithAuthorsDTO, CreateBook, UpdateBook, CreateBookDTO, UpdateBookDTO> {
    @Override
    public CreateBook createDTOToCreateModel(final CreateBookDTO createBookDTO, final Parameters parameters) {
        return new CreateBook(createBookDTO.isbn(), createBookDTO.title());
    }

    @Override
    public BookWithAuthorsDTO modelToDTO(final BookWithAuthors bookWithAuthors, final Parameters parameters) {
        return new BookWithAuthorsDTO(
                bookWithAuthors.book().id(),
                bookWithAuthors.book().isbn(),
                bookWithAuthors.book().title(),
                bookWithAuthors.authors().stream().map(this::authorToAuthorDTO).toList(),
                bookWithAuthors.book().createdAt(),
                bookWithAuthors.book().updatedAt()
        );
    }

    @Override
    public UpdateBook updateDTOToUpdateModel(final UpdateBookDTO updateBookDTO, final Parameters parameters) {
        return new UpdateBook(updateBookDTO.isbn(), updateBookDTO.title());
    }

    public AuthorDTO authorToAuthorDTO(final Author author) {
        return new AuthorDTO(
                author.id(),
                author.name(),
                author.birthDate(),
                author.createdAt(),
                author.updatedAt()
        );
    }
}
