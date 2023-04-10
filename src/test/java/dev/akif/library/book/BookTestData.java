package dev.akif.library.book;

import dev.akif.crud.CRUDTestData;
import dev.akif.crud.IdGenerator;
import dev.akif.crud.InMemoryCRUDRepository;
import dev.akif.crud.common.Paged;
import dev.akif.crud.common.Parameters;
import dev.akif.library.authorbook.BookWithAuthors;
import kotlin.Pair;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public final class BookTestData extends CRUDTestData<Long, BookEntity, BookWithAuthors, CreateBook, UpdateBook, BookTestData> {
    public final BookEntity bookEntity1 = new BookEntity(
            "ISBN 1",
            "Book 1",
            now()
    );

    public final BookEntity bookEntity2 = new BookEntity(
            "ISBN 2",
            "Book 2",
            now().plusSeconds(1)
    );

    public final BookEntity bookEntity3 = new BookEntity(
            "ISBN 3",
            "Book 3",
            now().plusSeconds(2)
    );

    public BookTestData() {
        super("Book");
        bookEntity1.setId(1L);
        bookEntity2.setId(2L);
        bookEntity3.setId(3L);
    }

    @Override
    public InMemoryCRUDRepository<Long, BookEntity, CreateBook, BookTestData> getRepository() {
        return BookTestHelper.INSTANCE.repository;
    }

    @Override
    public IdGenerator<Long> getIdGenerator() {
        return IdGenerator.sequential(0);
    }

    @Override
    public BookEntity getTestEntity1() {
        return bookEntity1;
    }

    @Override
    public BookEntity getTestEntity2() {
        return bookEntity2;
    }

    @Override
    public BookEntity getTestEntity3() {
        return bookEntity3;
    }

    @Override
    public BookEntity[] getMoreTestEntities() {
        return new BookEntity[0];
    }

    @Override
    public List<BookEntity> getDefaultFirstPageEntities() {
        return List.of(bookEntity1, bookEntity2, bookEntity3);
    }

    @Override
    public List<Pair<PageRequest, Paged<BookEntity>>> getPaginationTestCases() {
        return List.of(
                new Pair<>(
                        PageRequest.of(0, 2),
                        new Paged<>(List.of(bookEntity1, bookEntity2), 0, 2, 2)
                ),
                new Pair<>(
                        PageRequest.of(1, 2),
                        new Paged<>(List.of(bookEntity3), 1, 2, 2)
                ),
                new Pair<>(
                        PageRequest.of(2, 2),
                        new Paged<>(List.of(), 2, 2, 2)
                )
        );
    }

    @Override
    public Parameters getTestParameters() {
        return Parameters.empty;
    }

    @Override
    public boolean areDuplicates(final BookEntity e1, final BookEntity e2) {
        return e1.getIsbn().equals(e2.getIsbn());
    }

    @Override
    public BookEntity copy(final BookEntity bookEntity) {
        return new BookEntity(
                bookEntity.getId(),
                bookEntity.getIsbn(),
                bookEntity.getTitle(),
                bookEntity.getAuthors(),
                bookEntity.getVersion(),
                bookEntity.getCreatedAt(),
                bookEntity.getUpdatedAt(),
                bookEntity.getDeletedAt()
        );
    }

    @Override
    public CreateBook entityToCreateModel(final BookEntity bookEntity) {
        return new CreateBook(bookEntity.getIsbn(), bookEntity.getTitle());
    }

    @Override
    public UpdateBook entityToUpdateModelWithModifications(final BookEntity bookEntity) {
        return new UpdateBook(bookEntity.getIsbn() + "-updated", bookEntity.getTitle() + "-updated");
    }

    @Override
    public UpdateBook entityToUpdateModelWithNoModifications(final BookEntity bookEntity) {
        return new UpdateBook(bookEntity.getIsbn(), bookEntity.getTitle());
    }
}
