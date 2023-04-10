package dev.akif.library.author;

import dev.akif.crud.CRUDMapper;
import dev.akif.library.authorbook.AuthorWithBooks;
import dev.akif.library.book.Book;
import dev.akif.library.book.BookEntity;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.UUID;

@Component
public class AuthorMapper implements CRUDMapper<UUID, AuthorEntity, AuthorWithBooks, CreateAuthor, UpdateAuthor> {
    @Override
    public AuthorEntity entityToBeCreatedFrom(final CreateAuthor createAuthor, final Instant now) {
        return new AuthorEntity(createAuthor.name(), createAuthor.birthDate(), now);
    }

    @Override
    public AuthorWithBooks entityToModel(final AuthorEntity authorEntity) {
        return new AuthorWithBooks(
                new Author(
                    authorEntity.getId(),
                    authorEntity.getName(),
                    authorEntity.getBirthDate(),
                    authorEntity.getVersion(),
                    authorEntity.getCreatedAt(),
                    authorEntity.getUpdatedAt(),
                    authorEntity.getDeletedAt()
                ),
                authorEntity.getBooks().stream().map(this::bookEntityToBook).toList()
        );
    }

    @Override
    public void updateEntityWith(final AuthorEntity authorEntity, final UpdateAuthor updateAuthor) {
        authorEntity.setName(updateAuthor.name());
        authorEntity.setBirthDate(updateAuthor.birthDate());
    }

    private Book bookEntityToBook(final BookEntity bookEntity) {
        return new Book(
                bookEntity.getId(),
                bookEntity.getIsbn(),
                bookEntity.getTitle(),
                bookEntity.getVersion(),
                bookEntity.getCreatedAt(),
                bookEntity.getUpdatedAt(),
                bookEntity.getDeletedAt()
        );
    }
}
