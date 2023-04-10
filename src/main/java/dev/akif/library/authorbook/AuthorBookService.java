package dev.akif.library.authorbook;

import dev.akif.crud.common.Paged;
import dev.akif.crud.common.Parameters;
import dev.akif.library.author.Author;
import dev.akif.library.author.AuthorMapper;
import dev.akif.library.author.AuthorRepository;
import dev.akif.library.book.Book;
import dev.akif.library.book.BookMapper;
import dev.akif.library.book.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class AuthorBookService {
    private final AuthorRepository authors;
    private final BookRepository books;
    private final AuthorMapper authorMapper;
    private final BookMapper bookMapper;

    public Paged<Author> listAuthorsOfBook(final long bookId, final PageRequest pageRequest, final Parameters parameters) {
        return Optional
                .ofNullable(books.findByIdAndDeletedAtIsNull(bookId))
                .map(book ->
                        new Paged<>(
                                book.getAuthors().stream().map(authorMapper::entityToModel).map(AuthorWithBooks::author).toList(),
                                pageRequest
                        )
                )
                .orElseGet(() -> Paged.empty(pageRequest));
    }

    public Paged<Book> listBooksOfAuthor(final UUID authorId, final PageRequest pageRequest, final Parameters parameters) {
        return Optional
                .ofNullable(authors.findByIdAndDeletedAtIsNull(authorId))
                .map(author ->
                        new Paged<>(
                            author.getBooks().stream().map(bookMapper::entityToModel).map(BookWithAuthors::book).toList(),
                            pageRequest
                        )
                )
                .orElseGet(() -> Paged.empty(pageRequest));
    }
}
