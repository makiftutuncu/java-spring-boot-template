package dev.akif.library.book;

import dev.akif.crud.CRUDMapper;
import dev.akif.library.author.Author;
import dev.akif.library.author.AuthorEntity;
import dev.akif.library.authorbook.BookWithAuthors;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class BookMapper implements CRUDMapper<Long, BookEntity, BookWithAuthors, CreateBook, UpdateBook> {
    @Override
    public BookEntity entityToBeCreatedFrom(final CreateBook createBook, final Instant now) {
        return new BookEntity(createBook.isbn(), createBook.title(), now);
    }

    @Override
    public BookWithAuthors entityToModel(final BookEntity bookEntity) {
        return new BookWithAuthors(
                new Book(
                    bookEntity.getId(),
                    bookEntity.getIsbn(),
                    bookEntity.getTitle(),
                    bookEntity.getVersion(),
                    bookEntity.getCreatedAt(),
                    bookEntity.getUpdatedAt(),
                    bookEntity.getDeletedAt()
                ),
                bookEntity.getAuthors().stream().map(this::authorEntityToAuthor).toList()
        );
    }

    @Override
    public void updateEntityWith(final BookEntity bookEntity, final UpdateBook updateBook) {
        bookEntity.setIsbn(updateBook.isbn());
        bookEntity.setTitle(updateBook.title());
    }

    private Author authorEntityToAuthor(final AuthorEntity authorEntity) {
        return new Author(
                authorEntity.getId(),
                authorEntity.getName(),
                authorEntity.getBirthDate(),
                authorEntity.getVersion(),
                authorEntity.getCreatedAt(),
                authorEntity.getUpdatedAt(),
                authorEntity.getDeletedAt()
        );
    }
}
