package dev.akif.library.author;

import dev.akif.crud.CRUDDTOMapper;
import dev.akif.crud.common.Parameters;
import dev.akif.library.authorbook.AuthorWithBooks;
import dev.akif.library.book.Book;
import dev.akif.library.book.BookDTO;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AuthorDTOMapper implements CRUDDTOMapper<UUID, AuthorWithBooks, AuthorWithBooksDTO, CreateAuthor, UpdateAuthor, CreateAuthorDTO, UpdateAuthorDTO> {
    @Override
    public AuthorWithBooksDTO modelToDTO(final AuthorWithBooks authorWithBooks, final Parameters parameters) {
        return new AuthorWithBooksDTO(
                authorWithBooks.author().id(),
                authorWithBooks.author().name(),
                authorWithBooks.books().stream().map(this::bookToBookDTO).toList(),
                authorWithBooks.author().birthDate(),
                authorWithBooks.author().createdAt(),
                authorWithBooks.author().updatedAt()
        );
    }

    @Override
    public CreateAuthor createDTOToCreateModel(final CreateAuthorDTO createAuthorDTO, final Parameters parameters) {
        return new CreateAuthor(createAuthorDTO.name(), createAuthorDTO.birthDate());
    }

    @Override
    public UpdateAuthor updateDTOToUpdateModel(final UpdateAuthorDTO updateAuthorDTO, final Parameters parameters) {
        return new UpdateAuthor(updateAuthorDTO.name(), updateAuthorDTO.birthDate());
    }

    public BookDTO bookToBookDTO(final Book book) {
        return new BookDTO(
                book.id(),
                book.isbn(),
                book.title(),
                book.createdAt(),
                book.updatedAt()
        );
    }
}
