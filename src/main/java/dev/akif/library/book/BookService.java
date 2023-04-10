package dev.akif.library.book;

import dev.akif.crud.CRUDService;
import dev.akif.crud.common.InstantProvider;
import dev.akif.crud.common.Parameters;
import dev.akif.library.authorbook.BookWithAuthors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookService extends CRUDService<Long, BookEntity, BookWithAuthors, CreateBook, UpdateBook, BookRepository, BookMapper> {
    public BookService(final InstantProvider instantProvider, final BookRepository repository, final BookMapper mapper) {
        super("Book", instantProvider, repository, mapper);
    }

    @Override
    protected BookEntity createUsingRepository(final BookEntity bookEntity, final Parameters parameters) {
        return getRepository().save(bookEntity);
    }

    @Override
    protected BookEntity getUsingRepository(final Long id, final Parameters parameters) {
        return getRepository().findByIdAndDeletedAtIsNull(id);
    }

    @Override
    protected Page<BookEntity> listUsingRepository(final Pageable pageable, final Parameters parameters) {
        return getRepository().findAllByDeletedAtIsNull(pageable);
    }

    @Override
    protected int updateUsingRepository(final BookEntity bookEntity, final Parameters parameters) {
        return getRepository().update(bookEntity);
    }
}
